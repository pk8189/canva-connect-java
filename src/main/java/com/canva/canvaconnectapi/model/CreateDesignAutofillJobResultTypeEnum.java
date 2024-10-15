package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum CreateDesignAutofillJobResultTypeEnum {
    CREATE_DESIGN("create_design");

    private final String value;

    CreateDesignAutofillJobResultTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



