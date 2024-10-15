package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = FolderItemSummary.Deserializer.class)
public final class FolderItemSummary {
    private final Object value;

    private FolderItemSummary(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isFolderItemVariant() {
        return value instanceof FolderItem;
    }

    public FolderItem asFolderItemVariant() {
        return isFolderItemVariant() ? (FolderItem) value : null;
    }

    public boolean isDesignItemVariant() {
        return value instanceof DesignItem;
    }

    public DesignItem asDesignItemVariant() {
        return isDesignItemVariant() ? (DesignItem) value : null;
    }

    public boolean isImageItemVariant() {
        return value instanceof ImageItem;
    }

    public ImageItem asImageItemVariant() {
        return isImageItemVariant() ? (ImageItem) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        FolderItemSummary that = (FolderItemSummary) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static FolderItemSummary of(Object value) {
        if (value instanceof FolderItem || value instanceof DesignItem || value instanceof ImageItem) {
            return new FolderItemSummary(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends
        com.fasterxml.jackson.databind.JsonDeserializer<FolderItemSummary> {
        @Override
        public FolderItemSummary deserialize(com.fasterxml.jackson.core.JsonParser p,
                                             com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return FolderItemSummary.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return FolderItemSummary.of(ObjectMappers.JSON_MAPPER.convertValue(value, FolderItem.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return FolderItemSummary.of(ObjectMappers.JSON_MAPPER.convertValue(value, DesignItem.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return FolderItemSummary.of(ObjectMappers.JSON_MAPPER.convertValue(value, ImageItem.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



