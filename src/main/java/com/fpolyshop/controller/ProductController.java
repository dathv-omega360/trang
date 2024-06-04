package com.fpolyshop.controller;

import com.fpolyshop.entity.Product;
import com.fpolyshop.form.ProductForm;
import com.fpolyshop.service.IProductService;
import com.fpolyshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductForm product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody ProductForm productDetails) {
        Optional<Product> productOptional = productService.getProductById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product updatedProduct = productService.saveProduct(productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        if (!productService.getProductById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
