package com.ecommerce.ecommerce.Ecommerce_RepositoryInterface;

import com.ecommerce.ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
