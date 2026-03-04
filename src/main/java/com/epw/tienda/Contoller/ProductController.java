package com.epw.tienda.Contoller;

import com.epw.tienda.dto.ProductResponse;
import com.epw.tienda.dto.CreateProductRequest;
import com.epw.tienda.dto.UpdateProductRequest;
import com.epw.tienda.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tienda/com.epw.tienda")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@Valid @RequestBody CreateProductRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ProductResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PatchMapping("/{id}/done")
    public ProductResponse markDone(@PathVariable Long id) {
        return service.markDone(id);
    }

    @PatchMapping("/{id}/status")
    public ProductResponse changeStatus(@PathVariable Long id, @RequestParam String value) {
        return service.changeStatus(id, value);
    }
}