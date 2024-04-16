package com.shop.tomford.order.dto;

import com.shop.tomford.product.dto.ProductOptionDetailDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDto {
    private String orderId;
    private int productOptionId;
    private int quantity;
    private double price;
    private ProductOptionDetailDto productOption;

    public int getTotalPrice() {
        return (int) (quantity * price);
    }
}
