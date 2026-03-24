package com.epw.tienda.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.epw.tienda.Entity.Category;

public interface CategoryRepository extends JpaRepository <Category, Long> {} 