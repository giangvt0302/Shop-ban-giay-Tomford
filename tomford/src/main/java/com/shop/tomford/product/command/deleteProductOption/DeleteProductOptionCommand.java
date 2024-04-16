package com.shop.tomford.product.command.deleteProductOption;

import com.shop.tomford.common.Cqrs.IRequest;

public record DeleteProductOptionCommand(int id)  implements IRequest<Void> {
}
