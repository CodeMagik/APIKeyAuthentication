package com.codemagik.apikeyauth.security;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class APIKeyAuthenticationFilter extends OncePerRequestFilter {

    private AuthenticationManager authenticationManager;

    public APIKeyAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String auth = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if(auth != null && auth.startsWith("ApiKey")) {
            Authentication authentication = authenticationManager.authenticate(new APITokenUser(null, auth));
            if(authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
