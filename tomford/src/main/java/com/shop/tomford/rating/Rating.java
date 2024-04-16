package com.shop.tomford.rating;


import com.shop.tomford.common.AuditableEntity;
import com.shop.tomford.order.entity.Order;
import com.shop.tomford.product.entity.ProductOption;
import com.shop.tomford.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table

public class Rating extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int value;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductOption productOption;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
