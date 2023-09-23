package com.ecommerce.ecommerce.Ecommerce_Controller;


import com.ecommerce.ecommerce.Ecommerce_Service.ProductService;
import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.dto.InventoryWithProductAndCategoryDto;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.dto.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

 //   @GetMapping ("/getProductJoinsTableDto")
//    public List<ProductJoinsTableDto> getProductJoinsTable(){
//        return productService.getProductJoinsTableDto();
//    }

    @PostMapping ("/Ecommerce")
    public Product postData (@RequestBody ProductDto productDto) {
        return productService.saveData(productDto);
    }

    @GetMapping ("/{id}")
    public ProductWithCategoryDto getProductById(@PathVariable int id){
        return productService.getData(id);
    }

    @PutMapping ("/updateEcommerce/{id}")
    public ProductWithCategoryDto updateProductData(@PathVariable int id, @RequestBody ProductWithCategoryDto productWithCategoryDto){
        return productService.updateData(id, productWithCategoryDto);
    }

    @DeleteMapping ("/deleteEcommerce/{id}")
    public void deleteProductData (@PathVariable int id) {
        productService.deleteData(id);
    }

}
