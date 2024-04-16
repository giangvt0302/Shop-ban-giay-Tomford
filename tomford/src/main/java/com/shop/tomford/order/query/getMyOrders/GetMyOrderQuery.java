package com.shop.tomford.order.query.getMyOrders;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.order.dto.OrderDto;

import java.util.List;

public record GetMyOrderQuery() implements IRequest<List<OrderDto>> {

}
