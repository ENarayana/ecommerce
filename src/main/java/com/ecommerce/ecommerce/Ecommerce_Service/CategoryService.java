package com.ecommerce.ecommerce.Ecommerce_Service;

import com.ecommerce.ecommerce.Ecommerce_RepositoryInterface.CategoryRepository;
import com.ecommerce.ecommerce.Entity.Category;
import com.ecommerce.ecommerce.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryDto saveCategoryData (CategoryDto categoryDto) {

        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category saveCategory = categoryRepository.save(category);
        CategoryDto saveCategoryDto = new CategoryDto();
        saveCategoryDto.setCategoryDescription(saveCategory.getCategoryDescription());
        saveCategoryDto.setCategoryName(saveCategory.getCategoryName());
        return saveCategoryDto;
    }
    public List<Category> getAllData(){
        return categoryRepository.findAll();
    }

    public Category updateData (Category category){
        Category updatedCategory = categoryRepository.findById(category.getId()).orElse(null);

        if (updatedCategory!=null) {
           updatedCategory.setCategoryDescription(category.getCategoryDescription());
           updatedCategory.setCategoryName(category.getCategoryName());

           categoryRepository.save(category);
           return updatedCategory;
        }
        return null;
    }
}
