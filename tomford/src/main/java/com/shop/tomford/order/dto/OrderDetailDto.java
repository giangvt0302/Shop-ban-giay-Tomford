package com.shop.tomford.order.dto;

import com.shop.tomford.payment.dto.PaymentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDetailDto extends OrderDto{
    private List<PaymentDto> payments;
}
