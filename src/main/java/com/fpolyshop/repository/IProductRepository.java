package com.fpolyshop.repository;

import com.fpolyshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer>{
}
