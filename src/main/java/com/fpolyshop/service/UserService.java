package com.fpolyshop.service;

import com.fpolyshop.configuration.CustomUserDetails;
import com.fpolyshop.entity.Product;
import com.fpolyshop.entity.User;
import com.fpolyshop.form.UserForm;
import com.fpolyshop.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userRepository.findById(id).orElse(null));
    }

    @Override
    public User saveUser(UserForm form) {
        User user = mapper.map(form, User.class);
        String encodedPassword = encoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Can NOT found account has username = " + username);
        }
        return new CustomUserDetails(user);
    }

}
