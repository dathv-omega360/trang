package com.fpolyshop.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductForm {
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
}
