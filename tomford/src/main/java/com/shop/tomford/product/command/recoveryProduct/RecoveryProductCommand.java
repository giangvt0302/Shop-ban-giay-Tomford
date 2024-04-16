package com.shop.tomford.product.command.recoveryProduct;

import com.shop.tomford.common.Cqrs.IRequest;

public record RecoveryProductCommand(int product) implements IRequest<Void> {
}
