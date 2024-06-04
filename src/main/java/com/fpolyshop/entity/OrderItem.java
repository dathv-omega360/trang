package com.fpolyshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName  = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName  = "id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;
}
