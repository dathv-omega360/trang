package com.fpolyshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 250, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    @Column(name = "first_name", length = 250, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 250, nullable = false)
    private String lastName;

    @Formula(value = "concat_ws(' ', first_name, last_name)")
    private String fullName;

    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Column(name = "role", length = 250, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum Role{
        ADMIN, MANAGER, EMPLOYEE
    }
}
