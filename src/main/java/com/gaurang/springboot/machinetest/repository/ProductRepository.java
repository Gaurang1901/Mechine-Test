package com.gaurang.springboot.machinetest.repository;

import com.gaurang.springboot.machinetest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
