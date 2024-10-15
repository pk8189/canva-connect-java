package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum FolderItemTypeEnum1 {
    DESIGN("design"),
    FOLDER("folder"),
    IMAGE("image");

    private final String value;

    FolderItemTypeEnum1(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



