package com.fpolyshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @CreationTimestamp
    @Column(name = "invoice_date", nullable = false, updatable = false)
    private LocalDateTime invoiceDate;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
}
