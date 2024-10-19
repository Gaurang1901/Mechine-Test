package com.gaurang.springboot.machinetest.service;


import com.gaurang.springboot.machinetest.model.Category;
import com.gaurang.springboot.machinetest.repository.CategoryRepository;
import com.gaurang.springboot.machinetest.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryRequest createCategoryRequest) {

        Category category = new Category();
        category.setName(createCategoryRequest.getName());
        category.setDescription(createCategoryRequest.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(long categoryId,CategoryRequest updateCategoryRequest) throws Exception {

        Category category = getCategoryById(categoryId);

        if(updateCategoryRequest.getName()!=null){
            category.setName(updateCategoryRequest.getName());
        }
        if(updateCategoryRequest.getDescription()!=null) {
            category.setDescription(updateCategoryRequest.getDescription());
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long categoryId) throws Exception {

        Category category = getCategoryById(categoryId);

        categoryRepository.delete(category);
    }

    @Override
    public List<Category> getAllCategories(Integer pageNumber,Integer pageSize) {

        Pageable p = PageRequest.of(pageNumber,pageSize);

        Page<Category> categoryPage =  categoryRepository.findAll(p);

        return categoryPage.getContent();
    }

    @Override
    public Category getCategoryById(long categoryId) throws Exception {

        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()){
            throw new Exception("Category Not Found");
        }
        return optionalCategory.get();
    }
}
