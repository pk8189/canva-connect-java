package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum OwnershipTypeEnum {
    ANY("any"),
    OWNED("owned"),
    SHARED("shared");

    private final String value;

    OwnershipTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



