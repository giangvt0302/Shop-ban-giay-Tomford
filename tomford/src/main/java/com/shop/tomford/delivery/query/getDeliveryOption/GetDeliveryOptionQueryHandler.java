package com.shop.tomford.delivery.query.getDeliveryOption;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.delivery.IDeliveryService;
import com.shop.tomford.delivery.dto.GetValidShipServiceRequest;
import com.shop.tomford.delivery.dto.GetValidShipServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetDeliveryOptionQueryHandler implements IRequestHandler<GetDeliveryOptionQuery, List<GetValidShipServiceResponse>> {
    private final IDeliveryService deliveryService;

    @Override
    public HandleResponse<List<GetValidShipServiceResponse>> handle(GetDeliveryOptionQuery query) {
        var request = GetValidShipServiceRequest.builder()
                .toCity(query.getToProvince())
                .toDistrict(query.getToDistrict())
                .orderValue(query.getOrderValue())
                .cod(query.getCod()).build();
        var response = deliveryService.getValidShipService(request);
        return HandleResponse.ok(response);
    }
}
