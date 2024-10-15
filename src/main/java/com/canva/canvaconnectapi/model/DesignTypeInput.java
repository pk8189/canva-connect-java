package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = DesignTypeInput.Deserializer.class)
public final class DesignTypeInput {
    private final Object value;

    private DesignTypeInput(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isPresetDesignTypeInputVariant() {
        return value instanceof PresetDesignTypeInput;
    }

    public PresetDesignTypeInput asPresetDesignTypeInputVariant() {
        return isPresetDesignTypeInputVariant() ? (PresetDesignTypeInput) value : null;
    }

    public boolean isCustomDesignTypeInputVariant() {
        return value instanceof CustomDesignTypeInput;
    }

    public CustomDesignTypeInput asCustomDesignTypeInputVariant() {
        return isCustomDesignTypeInputVariant() ? (CustomDesignTypeInput) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        DesignTypeInput that = (DesignTypeInput) o;
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

    public static DesignTypeInput of(Object value) {
        if (value instanceof PresetDesignTypeInput || value instanceof CustomDesignTypeInput) {
            return new DesignTypeInput(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<DesignTypeInput> {
        @Override
        public DesignTypeInput deserialize(com.fasterxml.jackson.core.JsonParser p,
                                           com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return DesignTypeInput.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return DesignTypeInput.of(ObjectMappers.JSON_MAPPER.convertValue(value,
                                          PresetDesignTypeInput.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DesignTypeInput.of(ObjectMappers.JSON_MAPPER.convertValue(value,
                                          CustomDesignTypeInput.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



