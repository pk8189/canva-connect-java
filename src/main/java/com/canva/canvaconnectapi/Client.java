package com.canva.canvaconnectapi;

import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.resources.v1.V1Client;


public class Client {

    protected final ClientOptions clientOptions;
    protected final Supplier<V1Client> v1;

    public Client(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.v1 = Suppliers.memoize(() -> new V1Client(clientOptions));
    }

    public V1Client v1() {
        return this.v1.get();
    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

}
