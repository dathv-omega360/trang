package com.fpolyshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;
}
