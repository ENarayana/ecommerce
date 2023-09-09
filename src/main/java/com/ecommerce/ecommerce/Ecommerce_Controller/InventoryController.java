package com.ecommerce.ecommerce.Ecommerce_Controller;

import com.ecommerce.ecommerce.Ecommerce_RepositoryInterface.InventoryRepository;
import com.ecommerce.ecommerce.Ecommerce_Service.InventoryService;
import com.ecommerce.ecommerce.dto.InventoryDto;
import com.ecommerce.ecommerce.dto.InventoryWithProductAndCategoryDto;
import com.ecommerce.ecommerce.dto.InventoryWithProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping ("/postInventory")
    public InventoryDto postInventoryData (@RequestBody InventoryDto inventoryDto) {
        return inventoryService.saveInventoryData(inventoryDto);
    }

    @PutMapping ("/putInventory/{id}")
    public InventoryWithProductDto putInventoryData (@PathVariable int id, @RequestBody InventoryWithProductDto inventoryWithProductDto) {
        return inventoryService.updateInventoryData(id,inventoryWithProductDto);

    }

    @GetMapping ("/getInventory/{id}")
    public InventoryWithProductAndCategoryDto getInventoryData (@PathVariable int id) {
        return inventoryService.getAllInventoryData(id);
    }
}



