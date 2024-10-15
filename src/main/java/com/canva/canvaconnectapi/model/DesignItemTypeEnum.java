package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum DesignItemTypeEnum {
    DESIGN("design");

    private final String value;

    DesignItemTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



