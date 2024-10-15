package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum ExportErrorCodeEnum {
    INTERNAL_FAILURE("internal_failure"),
    LICENSE_REQUIRED("license_required");

    private final String value;

    ExportErrorCodeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



