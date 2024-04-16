package com.shop.tomford.order.dto;

import com.shop.tomford.common.dto.AuditableDto;
import com.shop.tomford.order.entity.enums.OrderStatus;
import com.shop.tomford.payment.dto.PaymentDto;
import com.shop.tomford.payment.entity.enums.PaymentMethod;
import com.shop.tomford.promotion.PromotionDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class OrderBriefDto extends AuditableDto {
    private String orderId;
    private String customerName;
    private String address;
    private PaymentMethod paymentMethod;
    private String phoneNumber;
    private String email;
    private int totalAmount;
    private String note;
    private double deliveryFee;
    private String cancelReason;
    private OrderStatus status = OrderStatus.PENDING;
    private PaymentDto latestPayment;
    private PromotionDto promotion;
    private LocalDateTime completedDate;
}
