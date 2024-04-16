package com.shop.tomford.cart.command.clearCart;

import com.shop.tomford.common.Cqrs.IRequest;

public record ClearCartCommand() implements IRequest<Integer> {
}
