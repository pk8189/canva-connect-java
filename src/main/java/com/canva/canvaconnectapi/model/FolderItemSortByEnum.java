package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum FolderItemSortByEnum {
    CREATED_ASCENDING("created_ascending"),
    CREATED_DESCENDING("created_descending"),
    MODIFIED_ASCENDING("modified_ascending"),
    MODIFIED_DESCENDING("modified_descending"),
    TITLE_ASCENDING("title_ascending"),
    TITLE_DESCENDING("title_descending");

    private final String value;

    FolderItemSortByEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



