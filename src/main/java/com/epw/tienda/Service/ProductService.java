package com.epw.tienda.Service;

import com.epw.tienda.dto.ProductResponse;
import com.epw.tienda.dto.CreateProductRequest;
import com.epw.tienda.dto.UpdateProductRequest;
import java.util.List;

public interface ProductService {
    ProductResponse create(CreateProductRequest request);

    List<ProductResponse> list();

    ProductResponse getById(Long id);

    ProductResponse update(Long id, UpdateProductRequest request);

    void delete(Long id);

    ProductResponse markDone(Long id);

    ProductResponse changeStatus(Long id, String status);
}