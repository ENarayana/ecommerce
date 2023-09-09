package com.ecommerce.ecommerce.Ecommerce_Service;

import com.ecommerce.ecommerce.Ecommerce_RepositoryInterface.InventoryRepository;
import com.ecommerce.ecommerce.Ecommerce_RepositoryInterface.ProductRepository;
import com.ecommerce.ecommerce.Entity.Inventory;
import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.dto.InventoryDto;
import com.ecommerce.ecommerce.dto.InventoryWithProductAndCategoryDto;
import com.ecommerce.ecommerce.dto.InventoryWithProductDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public InventoryRepository inventoryRepository;


    public InventoryDto saveInventoryData (InventoryDto inventoryDto) {

        Optional<Product> byId = productRepository.findById(inventoryDto.getProductId());

        Inventory inventory = new Inventory();

        inventory.setTotalQuantity(inventoryDto.getTotalQuantity());
        inventory.setRemainingQuantity(inventoryDto.getRemainingQuantity());
        inventory.setProduct(byId.get());
        inventory.setDate(new Date());

        Inventory savedInventory = inventoryRepository.save(inventory);

        InventoryDto savedInventoryDto = new InventoryDto();

        savedInventoryDto.setTotalQuantity(savedInventory.getTotalQuantity());
        savedInventoryDto.setRemainingQuantity(savedInventory.getRemainingQuantity());
        savedInventoryDto.setProductId(savedInventory.getProduct().getId());
        savedInventoryDto.setDate(savedInventory.getDate());

        return savedInventoryDto;
    }

    public InventoryWithProductDto updateInventoryData (int id, InventoryWithProductDto inventoryWithProductDto) {
        Inventory updatedInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("inventory Not Found" + id));

        updatedInventory.setTotalQuantity(inventoryWithProductDto.getTotalQuantity());
        updatedInventory.setRemainingQuantity(inventoryWithProductDto.getRemainingQuantity());
        updatedInventory.setDate(new Date());
      //  updatedInventory.setDate(inventoryWithProductDto.getDate());
        updatedInventory.getProduct().setName(inventoryWithProductDto.getName());
        updatedInventory.getProduct().setDescription(inventoryWithProductDto.getDescription());
        updatedInventory.getProduct().setPrice(inventoryWithProductDto.getPrice());

        inventoryRepository.save(updatedInventory);
        return inventoryWithProductDto;
    }

    public InventoryWithProductAndCategoryDto getAllInventoryData (int id) {
        Optional<Inventory> byId = inventoryRepository.findById(id);

        Inventory inventory = byId.get();

        InventoryWithProductAndCategoryDto inventoryWithProductAndCategoryDto = new InventoryWithProductAndCategoryDto();

        inventoryWithProductAndCategoryDto.setRemainingQuantity(inventory.getRemainingQuantity());

        inventoryWithProductAndCategoryDto.setProductId(inventory.getProduct().getId());

        inventoryWithProductAndCategoryDto.setName(inventory.getProduct().getName());
        inventoryWithProductAndCategoryDto.setDescription(inventory.getProduct().getDescription());
        inventoryWithProductAndCategoryDto.setPrice(inventory.getProduct().getPrice());
        inventoryWithProductAndCategoryDto.setCategoryId(inventory.getProduct().getCategory().getId());

        inventoryWithProductAndCategoryDto.setCategoryName(inventory.getProduct().getCategory().getCategoryName());
        inventoryWithProductAndCategoryDto.setCategoryDescription(inventory.getProduct().getCategory().getCategoryDescription());


        return inventoryWithProductAndCategoryDto;
    }

}
