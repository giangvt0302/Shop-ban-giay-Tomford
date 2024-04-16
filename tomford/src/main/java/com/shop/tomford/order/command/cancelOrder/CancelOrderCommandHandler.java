package com.shop.tomford.order.command.cancelOrder;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.config.CurrentUserService;
import com.shop.tomford.delivery.IDeliveryService;
import com.shop.tomford.order.entity.enums.OrderStatus;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.payment.entity.enums.PaymentStatus;
import com.shop.tomford.payment.repository.PaymentRepository;
import com.shop.tomford.product.repository.ProductOptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Service
public class CancelOrderCommandHandler implements IRequestHandler<CancelOrderCommand, Boolean> {
    private final OrderRepository _orderRepository;
    private final CurrentUserService _currentUserService;
    private final PaymentRepository _paymentRepository;
    private final IDeliveryService _deliveryService;
    private final ProductOptionRepository _productOptionRepository;

    @Override
    @Transactional
    public HandleResponse<Boolean> handle(CancelOrderCommand cancelOrderCommand) throws Exception {
        var order = _orderRepository.findById(cancelOrderCommand.getOrderId());
        if (order.isEmpty()) {
            return HandleResponse.error("Không tìm thấy đơn hàng");
        }

        if (!order.get().getUser().getUserId().equals(_currentUserService.getCurrentUserId().orElseThrow())) {
            return HandleResponse.error("Bạn không có quyền hủy đơn hàng này");
        }
        if (!(order.get().getStatus() == OrderStatus.PROCESSING || order.get().getStatus() == OrderStatus.PENDING)) {
            return HandleResponse.error("Đơn hàng không thể hủy");
        }
        var payment = _paymentRepository.findFirstByOrderIdSortedByCreatedDateDesc(order.get().getOrderId());
        if (payment.isPresent()) {
            if (payment.get().getStatus() == PaymentStatus.PAID) {
                payment.get().setStatus(PaymentStatus.WAITING_FOR_REFUND);
            } else {

                payment.get().setStatus(PaymentStatus.CANCELLED);
            }
            _paymentRepository.save(payment.get());

        }


        order.get().setStatus(OrderStatus.CANCELLED);
        order.get().setCancelReason(cancelOrderCommand.getReason());
        CompletableFuture.runAsync(() -> {
            try {
                _deliveryService.cancelOrder(order.get().getOrderId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        _orderRepository.save(order.get());
        for (var orderItem : order.get().getOrderItems()) {
            var productOption = orderItem.getProductOption();
            productOption.setStock(productOption.getStock() + orderItem.getQuantity());
            _productOptionRepository.save(productOption);
        }
        return HandleResponse.ok(true);
    }
}
