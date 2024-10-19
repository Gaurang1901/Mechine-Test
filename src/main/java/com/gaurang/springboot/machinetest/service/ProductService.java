package com.gaurang.springboot.machinetest.service;

import com.gaurang.springboot.machinetest.model.Category;
import com.gaurang.springboot.machinetest.model.Product;
import com.gaurang.springboot.machinetest.request.ProductRequest;

import java.util.List;

public interface ProductService {

    public Product createProduct(ProductRequest createProductRequest, Category category) throws Exception;

    public Product updateProduct(long productId, ProductRequest updateProductRequest) throws Exception;

    public void deleteProduct(long productId) throws Exception;

    public List<Product> getAllProducts(Integer pageNumber,Integer pageSize);

    public Product getProductById(long productId) throws Exception;

}
