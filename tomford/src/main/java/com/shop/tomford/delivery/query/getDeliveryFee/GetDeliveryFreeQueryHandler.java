package com.shop.tomford.delivery.query.getDeliveryFee;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.delivery.GiaoHangNhanhService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetDeliveryFreeQueryHandler implements IRequestHandler<GetDeliveryFeeQuery, Integer> {
    private final GiaoHangNhanhService giaoHangNhanhService;

    @Override
    public HandleResponse<Integer> handle(GetDeliveryFeeQuery getDeliveryFeeQuery) {

        try {
            return HandleResponse.ok(giaoHangNhanhService.getDeliveryFee(getDeliveryFeeQuery.getToProvince(), getDeliveryFeeQuery.getToDistrict(), getDeliveryFeeQuery.getToWard(), getDeliveryFeeQuery.getTotalPrice(), 600));
        } catch (Exception e) {
            return HandleResponse.error("Lỗi khi lấy phí vận chuyển");
        }
    }
}
