package com.example.library.security;

import com.example.library.entity.RoleType;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");  // ✅ Only for login
        }

        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                user.get().getRole() == RoleType.ROLE_ADMIN
                        ? List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
                        : List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
