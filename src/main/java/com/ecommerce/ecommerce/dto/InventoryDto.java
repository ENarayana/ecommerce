package com.ecommerce.ecommerce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InventoryDto {

    private int totalQuantity;
    private int remainingQuantity;
    private int productId;

    private Date date;

}
