package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum ExchangeRefreshTokenRequestGrantTypeEnum {
    REFRESH_TOKEN("refresh_token");

    private final String value;

    ExchangeRefreshTokenRequestGrantTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



