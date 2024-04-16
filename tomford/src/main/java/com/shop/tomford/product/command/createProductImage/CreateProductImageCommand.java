package com.shop.tomford.product.command.createProductImage;

import com.shop.tomford.common.Cqrs.IRequest;

public record CreateProductImageCommand(int productId, int colorId,String url) implements IRequest<Void> {
}
