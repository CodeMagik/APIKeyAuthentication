package com.codemagik.apikeyauth.secret;

import java.util.List;

public class ApplicationSecret {
    public List<ClientKey> getClientKeyList() {
        return clientKeyList;
    }

    public void setClientKeyList(List<ClientKey> clientKeyList) {
        this.clientKeyList = clientKeyList;
    }

    private List<ClientKey> clientKeyList;
}
