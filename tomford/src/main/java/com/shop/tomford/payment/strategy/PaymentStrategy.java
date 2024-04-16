package com.shop.tomford.payment.strategy;

import com.shop.tomford.payment.dto.CreatePaymentResponse;

public interface PaymentStrategy {
    CreatePaymentResponse createPayment(String orderId) throws Exception;
}
