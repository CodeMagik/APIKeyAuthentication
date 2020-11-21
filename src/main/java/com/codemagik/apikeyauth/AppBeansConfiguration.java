package com.codemagik.apikeyauth;

import com.codemagik.apikeyauth.secret.MockSecretRetriever;
import com.codemagik.apikeyauth.secret.SecretRetriever;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeansConfiguration {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }


    @Bean
    @Qualifier("mockSecretRetriever")
    public SecretRetriever getMockSecretRetriever() {
        return new MockSecretRetriever();
    }
}
