package com.epw.tienda.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {
    private List<OrderItemRequest> items;
}
