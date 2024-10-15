package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum AutofillErrorCodeEnum {
    AUTOFILL_ERROR("autofill_error"),
    CREATE_DESIGN_ERROR("create_design_error"),
    THUMBNAIL_GENERATION_ERROR("thumbnail_generation_error");

    private final String value;

    AutofillErrorCodeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



