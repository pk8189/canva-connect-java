package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum SortByTypeEnum {
    MODIFIED_ASCENDING("modified_ascending"),
    MODIFIED_DESCENDING("modified_descending"),
    RELEVANCE("relevance"),
    TITLE_ASCENDING("title_ascending"),
    TITLE_DESCENDING("title_descending");

    private final String value;

    SortByTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



