package com.ecommerce.ecommerce.Ecommerce_RepositoryInterface;

import com.ecommerce.ecommerce.Entity.Product;
//import com.ecommerce.ecommerce.dto.InventoryWithProductAndCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}

//    @Query(value =
//            "SELECT " +
//                    "    p.id AS product_id, " +
//                    "    p.name AS product_name, " +
//                    "    p.description AS product_description, " +
//                    "    p.price AS product_price, " +
//                    "    c.id AS category_id, " +
//                    "    c.name AS category_name, " +
//                    "    c.description AS category_description, " +
//                    "    i.total_quantity AS inventory_total_quantity, " +
//                    "    i.remaining_quantity AS inventory_remaining_quantity, " +
//                    "    i.date AS inventory_date " +
//                    "FROM " +
//                    "    Product p " +
//                    "JOIN " +
//                    "    Category c ON p.category_id = c.id " +
//                    "JOIN " +
//                    "    Inventory i ON p.id = i.product_id")
//
//    List<MyDto> findProductJoinsTableDto();

   // List<ProductJoinsTableDto> findProductJoinsTableDto();

//
//    @Query(value = "SELECT"
//          +  "p.id AS product_id, "
//          +  "p.name AS product_name, "
//          +  "p.description AS product_description, "
//          +  "p.price AS product_price, "
//          +  "c.id AS category_id, "
//          +  "c.name AS category_name, "
//          +  "c.description AS category_description, "
//          +  "i.total_quantity AS inventory_total_quantity, "
//          +  "i.remaining_quantity AS inventory_remaining_quantity, "
//          +  "i.date AS inventory_date "
//          +  "FROM "
//          +          "Product p "
//          +  "JOIN "
//          +          "Category c ON p.category_id = c.id "
//          +  "JOIN "
//          +  "Inventory i ON p.id = i.product_id ",nativeQuery = true )
//
//    List<InventoryWithProductAndCategoryDto> findInventoryWithProductAndCategoryDto();

