package com.shop.tomford.delivery.query.getDeliveryFee;

import com.shop.tomford.common.Cqrs.IRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class GetDeliveryFeeQuery implements IRequest<Integer> {

    @Size(min = 2, max = 30, message = "Tên tỉnh/thành phố phải có độ dài từ 2 đến 30 ký tự")

    @NotNull(message = "Tên tỉnh/thành phố không được để trống")
    private String toProvince;
    @Size(min = 2, max = 30, message = "Tên quận/huyện phải có độ dài từ 2 đến 30 ký tự")
    @NotNull(message = "Tên tỉnh/thành phố không được để trống")

    private String toDistrict;
    @NotNull(message = "Tên tỉnh/thành phố không được để trống")

    @Size(min = 2, max = 30, message = "Tên phường/xã phải có độ dài từ 2 đến 30 ký tự")

    private String toWard;
    private  int totalPrice;

}
