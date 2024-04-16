package com.shop.tomford.stockReceipt.query.getById;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.stockReceipt.dto.StockReceiptDetailDto;


public record GetStockReceiptByIdQuery(int id) implements IRequest<StockReceiptDetailDto> {

}
