package com.fpolyshop.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
