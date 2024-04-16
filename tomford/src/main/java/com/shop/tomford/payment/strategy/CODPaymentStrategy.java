package com.shop.tomford.payment.strategy;

import com.shop.tomford.common.BusinessLogicException;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.payment.dto.CreatePaymentResponse;
import com.shop.tomford.payment.entity.Payment;
import com.shop.tomford.payment.entity.enums.PaymentMethod;
import com.shop.tomford.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CODPaymentStrategy implements PaymentStrategy {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public CreatePaymentResponse createPayment(String orderId)  {
        var order = orderRepository.findById(orderId).orElseThrow(() -> new BusinessLogicException("Đon hàng không tồn tại"));

        var payment = Payment.builder().paymentId(UUID.randomUUID().toString())
                .amount(order.getTotalAmount())
                .order(order)
                .build();
        paymentRepository.save(payment);
        return CreatePaymentResponse.builder()
                .paymentId(orderId)
                .isRedirect(false)
                .paymentMethod(PaymentMethod.COD)
                .build();
    }
}
