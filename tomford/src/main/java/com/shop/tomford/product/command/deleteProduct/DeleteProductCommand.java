package com.shop.tomford.product.command.deleteProduct;

import com.shop.tomford.common.Cqrs.IRequest;

public record DeleteProductCommand(int id) implements IRequest<Void> {
}
