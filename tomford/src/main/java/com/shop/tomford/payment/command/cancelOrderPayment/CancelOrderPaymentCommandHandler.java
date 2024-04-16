package com.shop.tomford.payment.command.cancelOrderPayment;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CancelOrderPaymentCommandHandler implements IRequestHandler<CancelOrderPaymentCommand, Void> {
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(CancelOrderPaymentCommand cancelOrderPaymentCommand) throws Exception {
        var payment = paymentRepository.findFirstByOrderIdSortedByCreatedDateDesc(cancelOrderPaymentCommand.orderId());
        if (payment.isEmpty()) {
            return HandleResponse.error("Không tìm thấy thanh toán");
        }
        payment.get().setStatus(com.shop.tomford.payment.entity.enums.PaymentStatus.CANCELLED);
        paymentRepository.save(payment.get());
        return HandleResponse.ok();

    }
}
