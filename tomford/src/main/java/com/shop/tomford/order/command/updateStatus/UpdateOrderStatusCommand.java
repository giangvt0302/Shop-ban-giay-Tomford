package com.shop.tomford.order.command.updateStatus;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.order.entity.enums.OrderStatus;

public record UpdateOrderStatusCommand(String orderId, OrderStatus status) implements IRequest<Void> {
}
