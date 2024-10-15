package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum BooleanDataTableCellTypeEnum {
    BOOLEAN("boolean");

    private final String value;

    BooleanDataTableCellTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



