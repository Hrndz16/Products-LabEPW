package com.epw.tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epw.tienda.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
