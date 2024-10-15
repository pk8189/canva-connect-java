package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = DataTableCell.Deserializer.class)
public final class DataTableCell {
    private final Object value;

    private DataTableCell(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isStringDataTableCellVariant() {
        return value instanceof StringDataTableCell;
    }

    public StringDataTableCell asStringDataTableCellVariant() {
        return isStringDataTableCellVariant() ? (StringDataTableCell) value : null;
    }

    public boolean isNumberDataTableCellVariant() {
        return value instanceof NumberDataTableCell;
    }

    public NumberDataTableCell asNumberDataTableCellVariant() {
        return isNumberDataTableCellVariant() ? (NumberDataTableCell) value : null;
    }

    public boolean isBooleanDataTableCellVariant() {
        return value instanceof BooleanDataTableCell;
    }

    public BooleanDataTableCell asBooleanDataTableCellVariant() {
        return isBooleanDataTableCellVariant() ? (BooleanDataTableCell) value : null;
    }

    public boolean isDateDataTableCellVariant() {
        return value instanceof DateDataTableCell;
    }

    public DateDataTableCell asDateDataTableCellVariant() {
        return isDateDataTableCellVariant() ? (DateDataTableCell) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        DataTableCell that = (DataTableCell) o;
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

    public static DataTableCell of(Object value) {
        if (value instanceof StringDataTableCell || value instanceof NumberDataTableCell ||
                value instanceof BooleanDataTableCell || value instanceof DateDataTableCell) {
            return new DataTableCell(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<DataTableCell> {
        @Override
        public DataTableCell deserialize(com.fasterxml.jackson.core.JsonParser p,
                                         com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return DataTableCell.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataTableCell.of(ObjectMappers.JSON_MAPPER.convertValue(value, StringDataTableCell.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataTableCell.of(ObjectMappers.JSON_MAPPER.convertValue(value, NumberDataTableCell.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataTableCell.of(ObjectMappers.JSON_MAPPER.convertValue(value, BooleanDataTableCell.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return DataTableCell.of(ObjectMappers.JSON_MAPPER.convertValue(value, DateDataTableCell.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



