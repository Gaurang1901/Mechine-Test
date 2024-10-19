package com.gaurang.springboot.machinetest.controller;

import com.gaurang.springboot.machinetest.model.Category;
import com.gaurang.springboot.machinetest.model.Product;
import com.gaurang.springboot.machinetest.repository.CategoryRepository;
import com.gaurang.springboot.machinetest.repository.ProductRepository;
import com.gaurang.springboot.machinetest.request.ProductRequest;
import com.gaurang.springboot.machinetest.service.CategoryService;
import com.gaurang.springboot.machinetest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) throws Exception {

        Category category = categoryService.getCategoryById(request.getCategoryId());

        Product createdProduct = productService.createProduct(request, category);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @RequestBody ProductRequest request,
            @PathVariable Long id) throws Exception {

        Product updatedProduct = productService.updateProduct(id, request);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "4", required = false) Integer pageSize
    ) {

        List<Product> products = productService.getAllProducts(pageNumber, pageSize);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception {

        Product product = productService.getProductById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws Exception {

        productService.deleteProduct(id);

        return new ResponseEntity<>("Product with id " + id + " has been Deleted", HttpStatus.OK);
    }


}
