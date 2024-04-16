package com.shop.tomford.order.command.updateStatus;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.common.Cqrs.ISender;
import com.shop.tomford.config.ICurrentUserService;
import com.shop.tomford.order.command.cancelOrder.CancelOrderCommand;
import com.shop.tomford.order.entity.enums.OrderStatus;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.payment.command.cancelOrderPayment.CancelOrderPaymentCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class UpdateOrderStatusCommandHandler implements IRequestHandler<UpdateOrderStatusCommand, Void> {
    private final OrderRepository orderRepository;
    private final ISender sender;
    private final ICurrentUserService currentUserService;

    @Override
    @Transactional
    public HandleResponse<Void> handle(UpdateOrderStatusCommand updateOrderStatusCommand) throws Exception {
        var order = orderRepository.findById(updateOrderStatusCommand.orderId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy đơn hàng"));
        if (order.getStatus() != OrderStatus.CANCELLED && updateOrderStatusCommand.status() == OrderStatus.CANCELLED) {
            var cancelOrderCommand = new CancelOrderCommand();
            cancelOrderCommand.setOrderId(order.getOrderId());
            cancelOrderCommand.setReason("Huỷ bởi nhân viên " + currentUserService.getCurrentUserId().orElse(""));
            sender.send(cancelOrderCommand);
            sender.send(new CancelOrderPaymentCommand(order.getOrderId()));
            return HandleResponse.ok();
        }
        order.setStatus(updateOrderStatusCommand.status());
        if (order.getStatus() == OrderStatus.DELIVERED) {
            order.setCompletedDate(java.time.LocalDateTime.now());
        }


        orderRepository.save(order);
        return HandleResponse.ok();
    }
}
