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
@JsonDeserialize(builder = BooleanDataTableCell.Builder.class)
public final class BooleanDataTableCell {
    private final BooleanDataTableCellTypeEnum type;
    private final Optional<Boolean> value;

    private BooleanDataTableCell(
        BooleanDataTableCellTypeEnum type,
        Optional<Boolean> value
    ) {
        this.type = type;
        this.value = value;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public BooleanDataTableCellTypeEnum getType() {
        return type;
    }

    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getValue() {
        return value.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof BooleanDataTableCell && equalTo((BooleanDataTableCell) other);
    }

    private boolean equalTo(BooleanDataTableCell other) {
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
        return "BooleanDataTableCell{" +
               "type=" + type +
               "value=" + value +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private BooleanDataTableCellTypeEnum type = null;
        private Optional<Boolean> value = Optional.empty();

        private Builder() {}

        public Builder from(BooleanDataTableCell other) {
            type(other.getType());
            value(other.getValue());
            return this;
        }

        @JsonSetter("type")
        public Builder type(BooleanDataTableCellTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("value")
        public Builder value(Boolean value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        public Builder value(Optional<Boolean> value) {
            this.value = value;
            return this;
        }


        public BooleanDataTableCell build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new BooleanDataTableCell(
                       type,
                       value
                   );
        }
    }

}




