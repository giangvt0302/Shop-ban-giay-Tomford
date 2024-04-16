package com.shop.tomford.stockReceipt.query.getAllStockReceipts;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.stockReceipt.dto.StockReceiptBriefDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter

public class GetAllStockReceiptsQuery extends PaginationRequest implements IRequest<Paginated<StockReceiptBriefDto>> {
    private Long startDate;
    private Long endDate;

    private Integer supplierId;
    private int totalFrom = 0;

    private int totalTo = Integer.MAX_VALUE;

    public Date getStartDateObject() {
        return startDate == null ? null : new Date(startDate);
    }

    public Date getEndDateObject() {
        return endDate == null ? null : new Date(endDate);
    }
}
