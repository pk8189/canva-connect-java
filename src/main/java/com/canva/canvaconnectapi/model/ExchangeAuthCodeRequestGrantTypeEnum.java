package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum ExchangeAuthCodeRequestGrantTypeEnum {
    AUTHORIZATION_CODE("authorization_code");

    private final String value;

    ExchangeAuthCodeRequestGrantTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



