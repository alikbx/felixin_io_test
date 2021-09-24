package com.felixin.test.security;

import java.util.ArrayList;
import java.util.Collections;

import com.felixin.test.domain.FelixinUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (FelixinUser.user_id.equals(username)) {
            return new User(FelixinUser.user_id,
                    FelixinUser.password,
                    Collections.singletonList(new SimpleGrantedAuthority(FelixinUser.role)));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}