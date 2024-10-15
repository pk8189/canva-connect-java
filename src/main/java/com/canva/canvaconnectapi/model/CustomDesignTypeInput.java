package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CustomDesignTypeInput.Builder.class)
public final class CustomDesignTypeInput {
    /**
     * The height of the design (in pixels). Minimum 40px, maximum 8000px.
     */
    private final Integer height;
    private final CustomDesignTypeInputTypeEnum type;
    /**
     * The width of the design (in pixels). Minimum 40px, maximum 8000px.
     */
    private final Integer width;

    private CustomDesignTypeInput(
        Integer height,
        CustomDesignTypeInputTypeEnum type,
        Integer width
    ) {
        this.height = height;
        this.type = type;
        this.width = width;
    }

    @JsonProperty("height")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public CustomDesignTypeInputTypeEnum getType() {
        return type;
    }

    @JsonProperty("width")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getWidth() {
        return width;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CustomDesignTypeInput && equalTo((CustomDesignTypeInput) other);
    }

    private boolean equalTo(CustomDesignTypeInput other) {
        return
            height.equals(other.height) &&

            type.equals(other.type) &&

            width.equals(other.width)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.height,
                   this.type,
                   this.width
               );
    }

    @Override
    public String toString() {
        return "CustomDesignTypeInput{" +
               "height=" + height +
               "type=" + type +
               "width=" + width +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer height = null;
        private CustomDesignTypeInputTypeEnum type = null;
        private Integer width = null;

        private Builder() {}

        public Builder from(CustomDesignTypeInput other) {
            height(other.getHeight());
            type(other.getType());
            width(other.getWidth());
            return this;
        }

        @JsonSetter("height")
        public Builder height(Integer height) {
            if (height == null) {
                throw new IllegalArgumentException("height cannot be null");
            }

            this.height = height;
            return this;
        }


        @JsonSetter("type")
        public Builder type(CustomDesignTypeInputTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("width")
        public Builder width(Integer width) {
            if (width == null) {
                throw new IllegalArgumentException("width cannot be null");
            }

            this.width = width;
            return this;
        }



        public CustomDesignTypeInput build() {
            if (height == null) {
                throw new IllegalStateException("height is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            if (width == null) {
                throw new IllegalStateException("width is required");
            }

            return new CustomDesignTypeInput(
                       height,
                       type,
                       width
                   );
        }
    }

}




