package com.canva.canvaconnectapi.resources.v1.apps;

import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.resources.v1.apps.jwks.JwksClient;

public class AppsClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<JwksClient> jwks;
    public AppsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.jwks = Suppliers.memoize(() -> new JwksClient(clientOptions));
    }

    public JwksClient jwks() {
        return this.jwks.get();
    }
}

