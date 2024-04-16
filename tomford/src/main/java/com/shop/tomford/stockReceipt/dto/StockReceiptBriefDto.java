package com.shop.tomford.stockReceipt.dto;


import com.shop.tomford.common.dto.AuditableDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockReceiptBriefDto extends AuditableDto {
    private int stockReceiptId;
    private int total = 0;
    private String note;
    private int supplierId;
    private SupplierDto supplier;
}
