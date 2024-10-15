package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum DesignImportStatusEnum {
    FAILED("failed"),
    IN_PROGRESS("in_progress"),
    SUCCESS("success");

    private final String value;

    DesignImportStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



