package com.gaurang.springboot.machinetest.controller;

import com.gaurang.springboot.machinetest.model.Category;
import com.gaurang.springboot.machinetest.repository.CategoryRepository;
import com.gaurang.springboot.machinetest.request.CategoryRequest;
import com.gaurang.springboot.machinetest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest request) {

        Category createdCategory = categoryService.createCategory(request);

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(
            @RequestBody CategoryRequest request,
            @PathVariable Long id) throws Exception {

        Category updatedCategory = categoryService.updateCategory(id, request);

        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "4", required = false) Integer pageSize
            ) {

        List<Category> categories = categoryService.getAllCategories(pageNumber, pageSize);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) throws Exception {

        Category category = categoryService.getCategoryById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {

        categoryService.deleteCategory(id);

        return new ResponseEntity<>("Category with id " + id + " has been Deleted", HttpStatus.OK);
    }

}
