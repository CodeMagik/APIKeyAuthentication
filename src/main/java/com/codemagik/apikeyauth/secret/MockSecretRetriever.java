package com.codemagik.apikeyauth.secret;

import java.util.Arrays;
import java.util.List;

public class MockSecretRetriever implements SecretRetriever {
    @Override
    public List<ClientKey> getClientKeys() {
        ClientKey clientKey = new ClientKey();
        clientKey.setClientName("demoClient");
        clientKey.setApiKey("demoApiKey");

        return Arrays.asList(clientKey);
    }
}
