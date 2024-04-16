package com.shop.tomford.cart.command.updateCartItemQuantity;

import com.shop.tomford.common.Cqrs.IRequest;
import jakarta.validation.constraints.Min;


public record UpdateCartItemQuantityCommand(int productOptionId,    @Min(value = 1, message = "Số lượng phải lớn hơn 0") int newQuantity)implements IRequest<Void>{
}
