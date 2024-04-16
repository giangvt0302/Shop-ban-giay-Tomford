package com.shop.tomford.order.query.getOrderById;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.order.dto.OrderDetailDto;


public record GetOrderByIdQuery(String id) implements IRequest<OrderDetailDto> {

}
