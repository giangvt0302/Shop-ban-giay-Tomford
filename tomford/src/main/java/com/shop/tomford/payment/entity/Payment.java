package com.shop.tomford.payment.entity;

import com.shop.tomford.common.AuditableEntity;
import com.shop.tomford.payment.entity.enums.PaymentStatus;
import com.shop.tomford.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payment")
public class Payment extends AuditableEntity {
    @Id
    @Column(updatable = false, nullable = false, name = "payment_id", length = 36)
    private String paymentId;
    @Column(nullable = false)
    @Builder.Default
    private PaymentStatus status = PaymentStatus.PENDING;
    private int amount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    private LocalDateTime completedDate;

}
