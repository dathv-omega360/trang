package com.fpolyshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "invoice_id",referencedColumnName = "id")
    private Invoice invoice;

    @CreationTimestamp
    @Column(name = "payment_date", nullable = false, updatable = false)
    private LocalDateTime paymentDate;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "payment_method", length = 250, nullable = false)
    private String paymentMethod;
}
