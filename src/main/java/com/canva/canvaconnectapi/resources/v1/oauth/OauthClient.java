package com.canva.canvaconnectapi.resources.v1.oauth;

import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.resources.v1.oauth.introspect.IntrospectClient;
import com.canva.canvaconnectapi.resources.v1.oauth.revoke.RevokeClient;
import com.canva.canvaconnectapi.resources.v1.oauth.tokenresource.TokenClient;

public class OauthClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<IntrospectClient> introspect;
    protected final Supplier<RevokeClient> revoke;
    protected final Supplier<TokenClient> token;
    public OauthClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.introspect = Suppliers.memoize(() -> new IntrospectClient(clientOptions));
        this.revoke = Suppliers.memoize(() -> new RevokeClient(clientOptions));
        this.token = Suppliers.memoize(() -> new TokenClient(clientOptions));
    }

    public IntrospectClient introspect() {
        return this.introspect.get();
    }

    public RevokeClient revoke() {
        return this.revoke.get();
    }

    public TokenClient token() {
        return this.token.get();
    }
}

