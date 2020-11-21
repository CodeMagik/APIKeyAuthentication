package com.codemagik.apikeyauth.secret;

import java.util.List;

public interface SecretRetriever {
    List<ClientKey> getClientKeys();
}
