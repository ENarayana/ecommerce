package com.ecommerce.ecommerce.Ecommerce_RepositoryInterface;

import com.ecommerce.ecommerce.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {


    }
