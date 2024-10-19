package com.gaurang.springboot.machinetest.service;

import com.gaurang.springboot.machinetest.model.Category;
import com.gaurang.springboot.machinetest.model.Product;
import com.gaurang.springboot.machinetest.repository.CategoryRepository;
import com.gaurang.springboot.machinetest.repository.ProductRepository;
import com.gaurang.springboot.machinetest.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private  CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest createProductRequest, Category category) throws Exception {

        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setDescription(createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());
        product.setImageUrls(createProductRequest.getImageUrls());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(null);

        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        List<Product> products = new ArrayList<>();
        products.add(savedProduct);

        category.setProducts(products);
        categoryRepository.save(category);

        return savedProduct;
    }

    @Override
    public Product updateProduct(long productId, ProductRequest updateProductRequest) throws Exception {

        Product product = getProductById(productId);

        if (updateProductRequest.getName() != null) {
            product.setName(updateProductRequest.getName());
        }
        if (updateProductRequest.getDescription() != null) {
            product.setDescription(updateProductRequest.getDescription());
        }
        if (updateProductRequest.getQuantity() != null) {
            product.setQuantity(updateProductRequest.getQuantity());
        }
        if (updateProductRequest.getPrice() != null) {
            product.setPrice(updateProductRequest.getPrice());
        }
        if (updateProductRequest.getImageUrls()!=null) {
            product.setImageUrls(updateProductRequest.getImageUrls());
        }
        product.setUpdatedAt(LocalDateTime.now());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productId) throws Exception {

        Product product = getProductById(productId);

        productRepository.delete(product);
    }

    @Override
    public List<Product> getAllProducts(Integer pageNumber,Integer pageSize) {

        Pageable p = PageRequest.of(pageNumber,pageSize);

        Page<Product> pageProduct = productRepository.findAll(p);
        return pageProduct.getContent();
    }

    @Override
    public Product getProductById(long productId) throws Exception {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new Exception("Product Not Available");
        }
        return optionalProduct.get();
    }
}
