package com.canva.canvaconnectapi.resources.v1.users;

import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.resources.v1.users.me.MeClient;

public class UsersClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<MeClient> me;
    public UsersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.me = Suppliers.memoize(() -> new MeClient(clientOptions));
    }

    public MeClient me() {
        return this.me.get();
    }
}

