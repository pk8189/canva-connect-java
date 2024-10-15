package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum ExportPageSizeEnum {
    A3("a3"),
    A4("a4"),
    LEGAL("legal"),
    LETTER("letter");

    private final String value;

    ExportPageSizeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



