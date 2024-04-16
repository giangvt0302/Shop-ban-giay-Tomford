package com.shop.tomford.payment.command.createPayment;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.payment.dto.CreatePaymentResponse;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentCommand implements IRequest<CreatePaymentResponse> {
    @Pattern(regexp = "^[a-fA-F0-9]{8}(-[a-fA-F0-9]{4}){3}-[a-fA-F0-9]{12}$", message = "Mã đơn hàng không hợp lệ")
    private String orderId;


}
