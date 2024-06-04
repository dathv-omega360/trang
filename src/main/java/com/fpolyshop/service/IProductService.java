package com.fpolyshop.service;

import com.fpolyshop.entity.Product;
import com.fpolyshop.form.ProductForm;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(int id);

    Product saveProduct(ProductForm form);

    void deleteProduct(int id);
}
