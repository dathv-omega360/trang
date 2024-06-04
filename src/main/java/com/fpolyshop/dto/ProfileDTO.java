package com.fpolyshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    private int id;
    private String username;
    private String fullName;
    private String email;
    private String role;
}
