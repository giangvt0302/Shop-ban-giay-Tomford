package com.shop.tomford.payment.dto;

import com.shop.tomford.payment.entity.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentDto {
    private String paymentId;
    private PaymentStatus status = PaymentStatus.PENDING;

    private String paymentDetails;
    private String paymentResponse;
    private float amount;
}
