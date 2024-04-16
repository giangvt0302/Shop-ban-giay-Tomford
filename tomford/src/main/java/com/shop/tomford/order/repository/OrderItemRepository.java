package com.shop.tomford.order.repository;

import com.shop.tomford.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItem.OrderItemKey> {
    boolean existsByProductOptionId(int productOptionId);
}
