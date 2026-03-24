package com.login.login.domain.service;

import com.login.login.adapters.dto.AuthResponse;
import com.login.login.adapters.dto.AuthoLoginRequest;
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
import com.login.login.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
                permissions.forEach(permission
                        -> authorityList.add(new SimpleGrantedAuthority(permission.getName()))
                );
            }
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorityList
        );
    }

    public AuthResponse loginUser(AuthoLoginRequest authoLoginRequest) {
        String username = authoLoginRequest.username();
        String password = authoLoginRequest.password();

        //si las credenciales son correcras
        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //genera token
        String accessToken = jwtUtils.createToken(authentication);
        //usa el dto 
        AuthResponse authResponse = new AuthResponse(username, "User loged successfuly", accessToken, true);

        return authResponse;

    }

    public Authentication authenticate(String username, String password) {
        //busca en DB
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid  password");

        }
        
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

}
