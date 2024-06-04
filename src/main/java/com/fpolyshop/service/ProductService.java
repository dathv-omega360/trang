package com.fpolyshop.service;

import com.fpolyshop.entity.Product;

import com.fpolyshop.form.ProductForm;
import com.fpolyshop.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return Optional.ofNullable(productRepository.findById(id).orElse(null));
    }



    @Override
    public Product saveProduct (ProductForm form) {
        Product  product = mapper.map(form, Product.class);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
