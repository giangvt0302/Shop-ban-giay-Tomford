package com.shop.tomford.product.command.recoveryProductOption;

import com.shop.tomford.common.Cqrs.IRequest;

public record RecoveryProductOptionCommand(int productOptionId) implements IRequest<Void> {
}
