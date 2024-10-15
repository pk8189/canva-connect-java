package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum PresetDesignTypeNameEnum {
    DOC("doc"),
    PRESENTATION("presentation"),
    WHITEBOARD("whiteboard");

    private final String value;

    PresetDesignTypeNameEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



