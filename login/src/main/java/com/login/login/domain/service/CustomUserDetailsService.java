package com.login.login.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.login.login.domain.entity.User;
import com.login.login.domain.entity.Role;
import com.login.login.domain.entity.Permission;
import com.login.login.infraestructure.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // Get role and add as authority
        Role role = user.getRole();
        if (role != null) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            
            // Get permissions from role
            List<Permission> permissions = role.getPermissions();
            if (permissions != null) {
                permissions.forEach(permission -> 
                    authorityList.add(new SimpleGrantedAuthority(permission.getName()))
                );
            }
        }

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            authorityList
        );
    }
}
