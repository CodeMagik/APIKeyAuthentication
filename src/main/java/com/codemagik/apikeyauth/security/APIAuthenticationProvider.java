package com.codemagik.apikeyauth.security;

import com.codemagik.apikeyauth.secret.ClientKey;
import com.codemagik.apikeyauth.secret.SecretRetriever;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class APIAuthenticationProvider implements AuthenticationProvider {
    private final List<ClientKey> keys;
    private final SecretRetriever mockSecretRetriever;

    public APIAuthenticationProvider(SecretRetriever awsSecretRetriever) {
        this.mockSecretRetriever = awsSecretRetriever;
        this.keys = mockSecretRetriever.getClientKeys();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authorization = (String) authentication.getCredentials();

        if(authorization != null && authorization.startsWith("ApiKey")) {
            String[] key = authorization.split(" ");
            if(key.length == 2) {
                Optional<ClientKey> clientKey = keys.stream().filter(value -> value.getApiKey().equals(key[1])).findFirst();
                if(clientKey.isPresent()) {
                    return new APITokenUser(clientKey.get().getClientName(), null, new ArrayList<>());
                }
            }
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(APITokenUser.class);
    }
}
