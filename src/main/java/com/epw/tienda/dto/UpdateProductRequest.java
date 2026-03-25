package com.epw.tienda.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class UpdateProductRequest {
    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 chars")
    private String name;
    @Size(max = 2000, message = "description must be <= 2000 chars")
    private String description;
    @NotNull(message = "price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0")
    @Digits(integer = 12, fraction = 2, message = "price format is invalid")
    private BigDecimal price;
    @NotNull(message = "stock is required")
    @Min(value = 0, message = "stock must be >= 0")
    private Integer stock;
}