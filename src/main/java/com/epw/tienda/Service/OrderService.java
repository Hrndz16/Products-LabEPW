package com.epw.tienda.Service;

import com.epw.tienda.dto.CreateOrderRequest;
import com.epw.tienda.dto.CreateOrderResponse;

public interface OrderService {
    CreateOrderResponse create(CreateOrderRequest request);
}
