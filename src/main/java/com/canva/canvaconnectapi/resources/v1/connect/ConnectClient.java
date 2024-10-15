package com.canva.canvaconnectapi.resources.v1.connect;

import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.resources.v1.connect.keys.KeysClient;

public class ConnectClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<KeysClient> keys;
    public ConnectClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.keys = Suppliers.memoize(() -> new KeysClient(clientOptions));
    }

    public KeysClient keys() {
        return this.keys.get();
    }
}

