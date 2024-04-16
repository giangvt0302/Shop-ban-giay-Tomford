package com.shop.tomford.cart.command.removeItem;

import com.shop.tomford.common.Cqrs.IRequest;

public record RemoveItemFromCartCommand(int productOptionId) implements IRequest<Void> {
}
