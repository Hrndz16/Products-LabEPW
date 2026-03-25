package com.epw.tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epw.tienda.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}