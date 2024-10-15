package com.canva.canvaconnectapi.model;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = NumberDataTableCell.Builder.class)
public final class NumberDataTableCell {
    private final NumberDataTableCellTypeEnum type;
    private final Optional<Double> value;

    private NumberDataTableCell(
        NumberDataTableCellTypeEnum type,
        Optional<Double> value
    ) {
        this.type = type;
        this.value = value;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public NumberDataTableCellTypeEnum getType() {
        return type;
    }

    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Double getValue() {
        return value.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof NumberDataTableCell && equalTo((NumberDataTableCell) other);
    }

    private boolean equalTo(NumberDataTableCell other) {
        return
            type.equals(other.type) &&

            value.equals(other.value)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.type,
                   this.value
               );
    }

    @Override
    public String toString() {
        return "NumberDataTableCell{" +
               "type=" + type +
               "value=" + value +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private NumberDataTableCellTypeEnum type = null;
        private Optional<Double> value = Optional.empty();

        private Builder() {}

        public Builder from(NumberDataTableCell other) {
            type(other.getType());
            value(other.getValue());
            return this;
        }

        @JsonSetter("type")
        public Builder type(NumberDataTableCellTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("value")
        public Builder value(Double value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        public Builder value(Optional<Double> value) {
            this.value = value;
            return this;
        }


        public NumberDataTableCell build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new NumberDataTableCell(
                       type,
                       value
                   );
        }
    }

}




