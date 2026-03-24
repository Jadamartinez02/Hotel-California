package com.login.login.config.filter;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.login.login.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

//se ejecuta por cada request
public class JwtTokenValidator extends OncePerRequestFilter{
        
    private JwtUtils jwtUtils;

    public JwtTokenValidator(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }
    
    @Override
    protected  void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException{
        
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(jwtToken != null){
            //por que empieza con bearer
            jwtToken = jwtToken.substring(7);
            
            DecodedJWT decodedJwt =jwtUtils.valudateToken(jwtToken);
            
            String username = jwtUtils.extractUsername(decodedJwt);
            String stringAuthorities = jwtUtils.getSpecificClaim(decodedJwt, "authorities")
                    .asString();
            //da los permisos separados por coma y vuelve lista de  permisos
            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);
            
            //extrae el contexto de security
            SecurityContext context = SecurityContextHolder.getContext();
            //principal usuario, contraseña null por seguridsad y permisos 
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
            
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
        }
        filterChain.doFilter(request, response);
    }
}
