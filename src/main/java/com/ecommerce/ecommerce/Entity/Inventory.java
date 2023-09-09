package com.ecommerce.ecommerce.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table (name = "inventory")
public class Inventory {

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private int id;

    @Column (name = "TotalQuantity")
    private int totalQuantity;

    @Column (name = "RemainingQuantity")
    private int remainingQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "DATE")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Inventory(int id, int totalQuantity, int remainingQuantity, Product product, Date date) {
        this.id = id;
        this.totalQuantity = totalQuantity;
        this.remainingQuantity = remainingQuantity;
        this.product = product;
        this.date = new Date();
    }
    public Inventory () {
    }
}


