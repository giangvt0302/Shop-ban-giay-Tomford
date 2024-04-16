package com.shop.tomford.delivery;

import com.shop.tomford.delivery.dto.CreateShipOrderRequest;
import com.shop.tomford.delivery.dto.CreateShipOrderResponse;
import com.shop.tomford.delivery.dto.GetValidShipServiceRequest;
import com.shop.tomford.delivery.dto.GetValidShipServiceResponse;

import java.util.List;

public interface IDeliveryService {
     List<GetValidShipServiceResponse> getValidShipService(GetValidShipServiceRequest request);
     CreateShipOrderResponse createOrder(CreateShipOrderRequest request);
      void cancelOrder(String orderId);
}
