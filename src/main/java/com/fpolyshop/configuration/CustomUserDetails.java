package com.fpolyshop.configuration;

import com.fpolyshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data

public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Ở đây bạn có thể chuyển đổi Role từ User sang dạng Collection<GrantedAuthority>
        return AuthorityUtils.createAuthorityList(user.getRole().toString());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Bạn có thể tùy chỉnh logic này
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Bạn có thể tùy chỉnh logic này
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Bạn có thể tùy chỉnh logic này
    }

    @Override
    public boolean isEnabled() {
        return true; // Bạn có thể tùy chỉnh logic này
    }

    public User getUser() {
        return user;
    }
}
