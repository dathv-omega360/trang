package com.fpolyshop.repository;

import com.fpolyshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
