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
@JsonDeserialize(builder = DateDataTableCell.Builder.class)
public final class DateDataTableCell {
    private final DateDataTableCellTypeEnum type;
    private final Optional<Integer> value;

    private DateDataTableCell(
        DateDataTableCellTypeEnum type,
        Optional<Integer> value
    ) {
        this.type = type;
        this.value = value;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DateDataTableCellTypeEnum getType() {
        return type;
    }

    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getValue() {
        return value.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DateDataTableCell && equalTo((DateDataTableCell) other);
    }

    private boolean equalTo(DateDataTableCell other) {
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
        return "DateDataTableCell{" +
               "type=" + type +
               "value=" + value +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DateDataTableCellTypeEnum type = null;
        private Optional<Integer> value = Optional.empty();

        private Builder() {}

        public Builder from(DateDataTableCell other) {
            type(other.getType());
            value(other.getValue());
            return this;
        }

        @JsonSetter("type")
        public Builder type(DateDataTableCellTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("value")
        public Builder value(Integer value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        public Builder value(Optional<Integer> value) {
            this.value = value;
            return this;
        }


        public DateDataTableCell build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DateDataTableCell(
                       type,
                       value
                   );
        }
    }

}




