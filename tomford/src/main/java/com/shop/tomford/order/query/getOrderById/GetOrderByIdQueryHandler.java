package com.shop.tomford.order.query.getOrderById;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.order.dto.OrderDetailDto;
import com.shop.tomford.order.repository.OrderRepository;
import com.shop.tomford.payment.dto.PaymentDto;
import com.shop.tomford.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class GetOrderByIdQueryHandler implements IRequestHandler<GetOrderByIdQuery, OrderDetailDto> {
    private final ModelMapper _mapper;
    private final OrderRepository _orderRepository;
    private final PaymentRepository _paymentRepository;


    @Override
    @Transactional(readOnly = true)
    public HandleResponse<OrderDetailDto> handle(GetOrderByIdQuery getOrderByIdQuery) throws Exception {
        var order = _orderRepository.findById(getOrderByIdQuery.id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        var orderDto = _mapper.map(order, OrderDetailDto.class);
        var payment = _paymentRepository.findFirstByOrderIdSortedByCreatedDateDesc(order.getOrderId());
        payment.ifPresent(value -> orderDto.setLatestPayment(_mapper.map(value, PaymentDto.class)));
        


        return HandleResponse.ok(orderDto);
    }
}
