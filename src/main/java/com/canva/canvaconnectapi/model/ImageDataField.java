package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ImageDataField.Builder.class)
public final class ImageDataField {
    private final ImageDataFieldTypeEnum type;

    private ImageDataField(
        ImageDataFieldTypeEnum type
    ) {
        this.type = type;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ImageDataFieldTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ImageDataField && equalTo((ImageDataField) other);
    }

    private boolean equalTo(ImageDataField other) {
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
        return "ImageDataField{" +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ImageDataFieldTypeEnum type = null;

        private Builder() {}

        public Builder from(ImageDataField other) {
            type(other.getType());
            return this;
        }

        @JsonSetter("type")
        public Builder type(ImageDataFieldTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public ImageDataField build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new ImageDataField(
                       type
                   );
        }
    }

}




