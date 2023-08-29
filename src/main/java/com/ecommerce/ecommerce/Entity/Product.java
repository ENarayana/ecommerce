package com.ecommerce.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "product")
public class Product {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private int id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "DESCRIPTION")
    private String description;

    @Column (name = "PRICE")
    private double price;

    @ManyToOne
   @JoinColumn(name = "category_id", nullable = false)
   private Category category;

    public Product(int id, String name, String description, double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    public Product(){
    }
}
