package com.shop.tomford.stockReceipt.command.supplier.deleteSupplier;

import com.shop.tomford.common.Cqrs.IRequest;

public record DeleteSupplierCommand(int supplierId) implements IRequest<Void> {
}
