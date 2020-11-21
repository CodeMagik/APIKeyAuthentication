package com.codemagik.apikeyauth.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class APITokenUser extends UsernamePasswordAuthenticationToken {
    public APITokenUser(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public APITokenUser(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
