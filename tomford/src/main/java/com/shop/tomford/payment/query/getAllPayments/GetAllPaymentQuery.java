package com.shop.tomford.payment.query.getAllPayments;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.payment.dto.PaymentDto;
import com.shop.tomford.payment.entity.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetAllPaymentQuery extends PaginationRequest implements IRequest<Paginated<PaymentDto>> {
    private List<PaymentStatus> statuses = new ArrayList<>();
}
