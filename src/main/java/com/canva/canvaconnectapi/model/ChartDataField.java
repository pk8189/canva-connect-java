package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ChartDataField.Builder.class)
public final class ChartDataField {
    private final ChartDataFieldTypeEnum type;

    private ChartDataField(
        ChartDataFieldTypeEnum type
    ) {
        this.type = type;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ChartDataFieldTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ChartDataField && equalTo((ChartDataField) other);
    }

    private boolean equalTo(ChartDataField other) {
        return
            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.type
               );
    }

    @Override
    public String toString() {
        return "ChartDataField{" +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ChartDataFieldTypeEnum type = null;

        private Builder() {}

        public Builder from(ChartDataField other) {
            type(other.getType());
            return this;
        }

        @JsonSetter("type")
        public Builder type(ChartDataFieldTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public ChartDataField build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new ChartDataField(
                       type
                   );
        }
    }

}




