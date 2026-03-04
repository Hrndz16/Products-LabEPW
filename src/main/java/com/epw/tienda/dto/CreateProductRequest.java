package com.epw.tienda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.epw.tienda.Entity.ProductPriority;
import com.epw.tienda.Entity.ProductStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateProductRequest {
    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 chars")
    private String name;
    @Size(max = 2000, message = "description must be <= 2000 chars")
    private String description;
    @Size(max = 50, message = "price must be <= 50 chars")
    private BigDecimal price;
    @Size(max = 50, message = "stock must be <= 50 chars")
    private Integer stock;

    private ProductStatus status = ProductStatus.BACKLOG;
    private ProductPriority priority = ProductPriority.MEDIUM;
    private LocalDate dueDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public ProductPriority getPriority() {
        return priority;
    }

    public void setPriority(ProductPriority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
