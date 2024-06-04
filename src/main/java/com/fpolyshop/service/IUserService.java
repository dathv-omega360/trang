package com.fpolyshop.service;

import com.fpolyshop.entity.Product;
import com.fpolyshop.entity.User;
import com.fpolyshop.form.ProductForm;
import com.fpolyshop.form.UserForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {
    List<User> getAllUser();
    Optional<User> getUserById(int id);

    User saveUser(UserForm form);

    void deleteUser(int id);
    User findByUsername(String username);
}
