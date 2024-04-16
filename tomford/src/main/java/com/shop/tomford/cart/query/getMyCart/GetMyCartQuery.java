package com.shop.tomford.cart.query.getMyCart;

import com.shop.tomford.cart.dto.CartItemDto;
import com.shop.tomford.common.Cqrs.IRequest;

import java.util.Collection;

public record GetMyCartQuery() implements IRequest<Collection<CartItemDto>> {

}
