package com.shop.tomford.stockReceipt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StockReceiptDetailDto extends  StockReceiptBriefDto{
    private List<StockReceiptItemDto> stockReceiptItems;
}
