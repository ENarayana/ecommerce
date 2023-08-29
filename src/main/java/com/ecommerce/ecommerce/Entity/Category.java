package com.ecommerce.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@Table (name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private int id;

    @Column (name = "NAME")
    private String categoryName;

    @Column (name = "DESCRIPTION")
    private String categoryDescription;

}
