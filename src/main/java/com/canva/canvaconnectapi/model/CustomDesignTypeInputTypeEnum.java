package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum CustomDesignTypeInputTypeEnum {
    CUSTOM("custom");

    private final String value;

    CustomDesignTypeInputTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



