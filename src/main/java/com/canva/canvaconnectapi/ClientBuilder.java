package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.AuthBasic;
import com.canva.canvaconnectapi.core.AuthBearer;
import com.canva.canvaconnectapi.core.ClientOptions;

public final class ClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public ClientBuilder withBasicAuth(String username, String password) {
        this.clientOptionsBuilder.addAuth("basicAuth", new AuthBasic(username, password));
        return this;
    }

    public ClientBuilder withOauthAuthCode(String token) {
        this.clientOptionsBuilder.addAuth("oauthAuthCode", new AuthBearer(token));
        return this;
    }


    public ClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public ClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public Client build() {
        clientOptionsBuilder.environment(this.environment);
        return new Client(clientOptionsBuilder.build());
    }
}
