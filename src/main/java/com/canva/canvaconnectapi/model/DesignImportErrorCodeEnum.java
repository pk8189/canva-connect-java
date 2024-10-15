package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum DesignImportErrorCodeEnum {
    DESIGN_CREATION_THROTTLED("design_creation_throttled"),
    DESIGN_IMPORT_THROTTLED("design_import_throttled"),
    DUPLICATE_IMPORT("duplicate_import"),
    INTERNAL_ERROR("internal_error"),
    INVALID_FILE("invalid_file");

    private final String value;

    DesignImportErrorCodeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



