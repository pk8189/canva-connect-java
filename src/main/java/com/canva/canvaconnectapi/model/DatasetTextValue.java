package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DatasetTextValue.Builder.class)
public final class DatasetTextValue {
    /**
     * Text to insert into the template element.
     */
    private final String text;
    private final DatasetTextValueTypeEnum type;

    private DatasetTextValue(
        String text,
        DatasetTextValueTypeEnum type
    ) {
        this.text = text;
        this.type = type;
    }

    @JsonProperty("text")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getText() {
        return text;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DatasetTextValueTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DatasetTextValue && equalTo((DatasetTextValue) other);
    }

    private boolean equalTo(DatasetTextValue other) {
        return
            text.equals(other.text) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.text,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "DatasetTextValue{" +
               "text=" + text +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String text = null;
        private DatasetTextValueTypeEnum type = null;

        private Builder() {}

        public Builder from(DatasetTextValue other) {
            text(other.getText());
            type(other.getType());
            return this;
        }

        @JsonSetter("text")
        public Builder text(String text) {
            if (text == null) {
                throw new IllegalArgumentException("text cannot be null");
            }

            this.text = text;
            return this;
        }


        @JsonSetter("type")
        public Builder type(DatasetTextValueTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public DatasetTextValue build() {
            if (text == null) {
                throw new IllegalStateException("text is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DatasetTextValue(
                       text,
                       type
                   );
        }
    }

}




