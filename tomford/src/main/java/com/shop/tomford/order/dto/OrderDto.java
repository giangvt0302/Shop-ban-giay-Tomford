package com.shop.tomford.order.dto;

import com.shop.tomford.common.dto.AuditableDto;
import com.shop.tomford.order.entity.enums.OrderStatus;
import com.shop.tomford.payment.dto.PaymentDto;
import com.shop.tomford.payment.entity.enums.PaymentMethod;
import com.shop.tomford.promotion.PromotionDto;
import com.shop.tomford.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class OrderDto extends AuditableDto {

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
    private UserDto user;
    private LocalDateTime completedDate;
    public String getCompletedDateDisplay() {
        return completedDate != null ? completedDate.format(DateTimeFormatter.ofPattern(" HH:mm dd/MM/yyyy")) : "";
    }

    private java.util.List<OrderItemDto> orderItems;
    public int getTotalPrice() {
        return orderItems.stream().mapToInt(OrderItemDto::getTotalPrice).sum();
    }
    public int getReducePrice() {
        return (int) (getTotalPrice() + deliveryFee - totalAmount);
    }
}
