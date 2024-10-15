package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum Mp4ExportQualityEnum {
    HORIZONTAL_1080P("horizontal_1080p"),
    HORIZONTAL_480P("horizontal_480p"),
    HORIZONTAL_4K("horizontal_4k"),
    HORIZONTAL_720P("horizontal_720p"),
    VERTICAL_1080P("vertical_1080p"),
    VERTICAL_480P("vertical_480p"),
    VERTICAL_4K("vertical_4k"),
    VERTICAL_720P("vertical_720p");

    private final String value;

    Mp4ExportQualityEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



