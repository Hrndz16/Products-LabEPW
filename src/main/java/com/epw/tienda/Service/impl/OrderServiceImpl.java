package com.epw.tienda.Service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.tienda.Entity.Order;
import com.epw.tienda.Entity.OrderItem;
import com.epw.tienda.Entity.Product;
import com.epw.tienda.Repository.OrderRepository;
import com.epw.tienda.Repository.ProductRepository;
import com.epw.tienda.Service.OrderService;
import com.epw.tienda.dto.CreateOrderRequest;
import com.epw.tienda.dto.CreateOrderResponse;
import com.epw.tienda.dto.OrderItemRequest;
import com.epw.tienda.dto.OrderItemResponse;
import com.epw.tienda.exception.ResourceNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CreateOrderResponse create(CreateOrderRequest request) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        Order order = new Order();
        List<OrderItem> items = new ArrayList<>();

        for (OrderItemRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Product " + itemRequest.getProductId() + " not found"));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemRequest.getQuantity());
            item.setUnitPrice(product.getPrice());

            items.add(item);
        }

        order.setItems(items);
        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    private CreateOrderResponse toResponse(Order order) {
        CreateOrderResponse response = new CreateOrderResponse();
        response.setId(order.getId());
        response.setCreatedAt(order.getCreatedAt());

        List<OrderItemResponse> itemResponses = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {
            OrderItemResponse itemResponse = new OrderItemResponse();
            itemResponse.setProductId(item.getProduct().getId());
            itemResponse.setProductName(item.getProduct().getName());
            itemResponse.setQuantity(item.getQuantity());
            itemResponse.setUnitPrice(item.getUnitPrice());

            BigDecimal subtotal = item.getUnitPrice()
                    .multiply(BigDecimal.valueOf(item.getQuantity()));
            itemResponse.setSubtotal(subtotal);

            total = total.add(subtotal);
            itemResponses.add(itemResponse);
        }

        response.setItems(itemResponses);
        response.setTotal(total);
        return response;
    }
}
