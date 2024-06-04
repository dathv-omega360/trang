package com.fpolyshop.controller;

import com.fpolyshop.entity.Product;
import com.fpolyshop.entity.User;
import com.fpolyshop.form.ProductForm;
import com.fpolyshop.form.UserForm;
import com.fpolyshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAllProducts() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserForm user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateProduct(@PathVariable int id, @RequestBody UserForm UserDetails) {
        Optional<User> userOptional = userService.getUserById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User updatedUser = userService.saveUser(UserDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        if (!userService.getUserById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
