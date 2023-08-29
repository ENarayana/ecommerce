package com.ecommerce.ecommerce.Ecommerce_RepositoryInterface;

import com.ecommerce.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
