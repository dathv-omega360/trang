package com.fpolyshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;
}
