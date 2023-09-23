package com.ecommerce.ecommerce.dto;

import lombok.Data;


@Data
public class InventoryWithProductAndCategoryDto {

    private int remainingQuantity;

    private int productId;

    private String name;
    private String description;
    private double price;
    private int categoryId;

    private String categoryName;
    private String categoryDescription;
}
