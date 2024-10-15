package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum DatasetFilterEnum {
    ANY("any"),
    EMPTY("empty"),
    NON_EMPTY("non_empty");

    private final String value;

    DatasetFilterEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



