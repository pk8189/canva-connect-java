package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TextDataField.Builder.class)
public final class TextDataField {
    private final TextDataFieldTypeEnum type;

    private TextDataField(
        TextDataFieldTypeEnum type
    ) {
        this.type = type;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public TextDataFieldTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TextDataField && equalTo((TextDataField) other);
    }

    private boolean equalTo(TextDataField other) {
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
        return "TextDataField{" +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private TextDataFieldTypeEnum type = null;

        private Builder() {}

        public Builder from(TextDataField other) {
            type(other.getType());
            return this;
        }

        @JsonSetter("type")
        public Builder type(TextDataFieldTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public TextDataField build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new TextDataField(
                       type
                   );
        }
    }

}




