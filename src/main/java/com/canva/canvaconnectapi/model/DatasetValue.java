package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = DatasetValue.Deserializer.class)
public final class DatasetValue {
    private final Object value;

    private DatasetValue(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isDatasetImageValueVariant() {
        return value instanceof DatasetImageValue;
    }

    public DatasetImageValue asDatasetImageValueVariant() {
        return isDatasetImageValueVariant() ? (DatasetImageValue) value : null;
    }

    public boolean isDatasetTextValueVariant() {
        return value instanceof DatasetTextValue;
    }

    public DatasetTextValue asDatasetTextValueVariant() {
        return isDatasetTextValueVariant() ? (DatasetTextValue) value : null;
    }

    public boolean isDatasetChartValueVariant() {
        return value instanceof DatasetChartValue;
    }

    public DatasetChartValue asDatasetChartValueVariant() {
        return isDatasetChartValueVariant() ? (DatasetChartValue) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        DatasetValue that = (DatasetValue) o;
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

    public static DatasetValue of(Object value) {
        if (value instanceof DatasetImageValue || value instanceof DatasetTextValue ||
                value instanceof DatasetChartValue) {
            return new DatasetValue(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<DatasetValue> {
        @Override
        public DatasetValue deserialize(com.fasterxml.jackson.core.JsonParser p,
                                        com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return DatasetValue.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return DatasetValue.of(ObjectMappers.JSON_MAPPER.convertValue(value, DatasetImageValue.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DatasetValue.of(ObjectMappers.JSON_MAPPER.convertValue(value, DatasetTextValue.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DatasetValue.of(ObjectMappers.JSON_MAPPER.convertValue(value, DatasetChartValue.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



