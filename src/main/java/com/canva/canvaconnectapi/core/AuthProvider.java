package com.canva.canvaconnectapi.core;

public interface AuthProvider {

    public HttpRequestBuilder addAuth(HttpRequestBuilder builder);

}
