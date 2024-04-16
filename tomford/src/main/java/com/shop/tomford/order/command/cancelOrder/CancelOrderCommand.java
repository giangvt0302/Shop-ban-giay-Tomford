package com.shop.tomford.order.command.cancelOrder;

import com.shop.tomford.common.Cqrs.IRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CancelOrderCommand implements IRequest<Boolean> {
    @NotEmpty(message = "Mã đơn hàng không được để trống")
   private String orderId ;
   private String reason ;
}
