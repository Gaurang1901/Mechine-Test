package com.gaurang.springboot.machinetest.service;

import com.gaurang.springboot.machinetest.model.Category;
import com.gaurang.springboot.machinetest.request.CategoryRequest;

import java.util.List;

public interface CategoryService {

    public Category createCategory(CategoryRequest createCategoryRequest);

    public Category updateCategory(long categoryId,CategoryRequest updateCategoryRequest) throws Exception;

    public void deleteCategory(long categoryId) throws Exception;

    public List<Category> getAllCategories(Integer pageNumber,Integer pageSize);

    public Category getCategoryById(long categoryId) throws Exception;

}
