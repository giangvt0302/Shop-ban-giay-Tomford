package com.shop.tomford.stockReceipt.dto;

import com.shop.tomford.product.dto.ProductOptionDetailDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockReceiptItemDto {
    private int stockReceiptId;
    private int productOptionId;
    private int quantity;
    private int price = 0;
    private ProductOptionDetailDto productOption;
}
