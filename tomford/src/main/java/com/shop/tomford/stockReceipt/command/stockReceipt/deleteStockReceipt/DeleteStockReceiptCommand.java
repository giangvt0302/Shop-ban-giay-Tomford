package com.shop.tomford.stockReceipt.command.stockReceipt.deleteStockReceipt;

import com.shop.tomford.common.Cqrs.IRequest;

public record DeleteStockReceiptCommand (int stockReceiptId) implements IRequest<Void> {
}
