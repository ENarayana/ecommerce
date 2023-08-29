package com.ecommerce.ecommerce.Ecommerce_Controller;

import com.ecommerce.ecommerce.Ecommerce_Service.CategoryService;
import com.ecommerce.ecommerce.Entity.Category;
import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping ("/Category")
    public CategoryDto postData (@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategoryData(categoryDto);
    }
    @GetMapping ("/getCategory")
    public List<Category> getAllCategoryData (){
        return categoryService.getAllData();
    }

    @PutMapping ("/updateCategory")
    public Category postCategoryData (@RequestBody Category category) {
        return categoryService.updateData(category);
    }

}
