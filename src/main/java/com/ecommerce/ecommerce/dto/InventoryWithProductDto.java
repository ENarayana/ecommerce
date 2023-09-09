package com.ecommerce.ecommerce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InventoryWithProductDto {

    private int totalQuantity;
    private int remainingQuantity;
    private int productId;

    private Date date;

    // Product Dto
    private String name;
    private String description;
    private double price;
    private int categoryId;
}
