package com.fpolyshop.controller;

import com.fpolyshop.configuration.CustomUserDetails;
import com.fpolyshop.configuration.JwtTokenProvider;
import com.fpolyshop.dto.ProfileDTO;
import com.fpolyshop.entity.User;
import com.fpolyshop.form.UserForm;
import com.fpolyshop.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IUserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> register(@RequestBody UserForm form) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .toList();
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserForm userForm, Principal principal) {
        // Tạo đối tượng User từ UserForm
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setRole(User.Role.valueOf(userForm.getRole()));

        // Lưu người dùng vào database
        User createdUser = userService.saveUser(user);

        return ResponseEntity.ok(createdUser);
    }
}
