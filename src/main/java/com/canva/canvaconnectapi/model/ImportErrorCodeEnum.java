package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum ImportErrorCodeEnum {
    FILE_TOO_BIG("file_too_big"),
    IMPORT_FAILED("import_failed");

    private final String value;

    ImportErrorCodeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



