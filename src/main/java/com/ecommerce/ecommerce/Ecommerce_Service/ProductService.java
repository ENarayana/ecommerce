package com.ecommerce.ecommerce.Ecommerce_Service;

import com.ecommerce.ecommerce.Ecommerce_RepositoryInterface.CategoryRepository;
import com.ecommerce.ecommerce.Ecommerce_RepositoryInterface.ProductRepository;
import com.ecommerce.ecommerce.Entity.Category;
import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.dto.ProductWithCategoryDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;



    @Autowired
    private ProductRepository productRepository;


    public Product saveData (ProductDto productDto){
        Optional<Category> byId = categoryRepository.findById(productDto.getCategoryId());
        //create product object
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(byId.get());
        return productRepository.save(product);

    }

    public ProductWithCategoryDto getData (int id){
        Optional<Product> byId = productRepository.findById(id);

        Product product = byId.get();
        ProductWithCategoryDto productWithCategoryDto = new ProductWithCategoryDto();
        productWithCategoryDto.setName(product.getName());
        productWithCategoryDto.setDescription(product.getDescription());
        productWithCategoryDto.setPrice(product.getPrice());
        productWithCategoryDto.setCategoryId(product.getCategory().getId());
        productWithCategoryDto.setCategoryName(product.getCategory().getCategoryName());
        productWithCategoryDto.setCategoryDescription(product.getCategory().getCategoryDescription());

        return productWithCategoryDto;
            }

    public ProductWithCategoryDto updateData (int id, ProductWithCategoryDto productWithCategoryDto) {
        Product updatedProduct = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        updatedProduct.setName(productWithCategoryDto.getName());
        updatedProduct.setPrice(productWithCategoryDto.getPrice());
        updatedProduct.setDescription(productWithCategoryDto.getDescription());
        updatedProduct.getCategory().setCategoryName(productWithCategoryDto.getCategoryName());
        updatedProduct.getCategory().setCategoryDescription(productWithCategoryDto.getCategoryDescription());

         productRepository.save(updatedProduct);
         return productWithCategoryDto;

   }

       public void deleteData (int id) {
       productRepository.deleteById(id);

   }

//    public Product deleteData (Product product) {
//      return productRepository.deleteById(product);
//
//    }

}
