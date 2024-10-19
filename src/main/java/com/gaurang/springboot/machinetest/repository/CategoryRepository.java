package com.gaurang.springboot.machinetest.repository;

import com.gaurang.springboot.machinetest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
