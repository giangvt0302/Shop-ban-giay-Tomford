package com.shop.tomford.payment.command.createPayment;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.order.entity.enums.OrderStatus;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.payment.PaymentStrategyFactory;
import com.shop.tomford.payment.dto.CreatePaymentResponse;
import com.shop.tomford.payment.entity.enums.PaymentStatus;
import com.shop.tomford.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreatePaymentCommandHandler implements IRequestHandler<CreatePaymentCommand, CreatePaymentResponse> {
    private final PaymentStrategyFactory paymentStrategyFactory;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    @Override
    public HandleResponse<CreatePaymentResponse> handle(CreatePaymentCommand createPaymentCommand) throws Exception {

        var order = orderRepository.findById(createPaymentCommand.getOrderId()).orElse(null);
        if (order == null) {
            return HandleResponse.error("Đơn hàng không tồn tại");
        }
        var lastPayment = paymentRepository.findFirstByOrderIdSortedByCreatedDateDesc(createPaymentCommand.getOrderId()).orElse(null);

        if(lastPayment != null && lastPayment.getStatus() == PaymentStatus.PAID){
            return HandleResponse.error("Đơn hàng đã được thanh toán");
        }

        if(lastPayment != null &&lastPayment.getOrder().getStatus()== OrderStatus.CANCELLED){
            return HandleResponse.error("Đơn hàng đã bị hủy");
        }

        var paymentStrategy = paymentStrategyFactory.getPaymentStrategy(order.getPaymentMethod());
        var response = paymentStrategy.createPayment(createPaymentCommand.getOrderId());
        return HandleResponse.ok(response);
    }
}
