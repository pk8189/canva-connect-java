package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = DataField.Deserializer.class)
public final class DataField {
    private final Object value;

    private DataField(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isImageDataFieldVariant() {
        return value instanceof ImageDataField;
    }

    public ImageDataField asImageDataFieldVariant() {
        return isImageDataFieldVariant() ? (ImageDataField) value : null;
    }

    public boolean isTextDataFieldVariant() {
        return value instanceof TextDataField;
    }

    public TextDataField asTextDataFieldVariant() {
        return isTextDataFieldVariant() ? (TextDataField) value : null;
    }

    public boolean isChartDataFieldVariant() {
        return value instanceof ChartDataField;
    }

    public ChartDataField asChartDataFieldVariant() {
        return isChartDataFieldVariant() ? (ChartDataField) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        DataField that = (DataField) o;
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

    public static DataField of(Object value) {
        if (value instanceof ImageDataField || value instanceof TextDataField ||
                value instanceof ChartDataField) {
            return new DataField(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<DataField> {
        @Override
        public DataField deserialize(com.fasterxml.jackson.core.JsonParser p,
                                     com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return DataField.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataField.of(ObjectMappers.JSON_MAPPER.convertValue(value, ImageDataField.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataField.of(ObjectMappers.JSON_MAPPER.convertValue(value, TextDataField.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataField.of(ObjectMappers.JSON_MAPPER.convertValue(value, ChartDataField.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



