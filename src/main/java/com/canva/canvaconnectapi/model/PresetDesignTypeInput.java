package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PresetDesignTypeInput.Builder.class)
public final class PresetDesignTypeInput {
    private final PresetDesignTypeNameEnum name;
    private final PresetDesignTypeInputTypeEnum type;

    private PresetDesignTypeInput(
        PresetDesignTypeNameEnum name,
        PresetDesignTypeInputTypeEnum type
    ) {
        this.name = name;
        this.type = type;
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public PresetDesignTypeNameEnum getName() {
        return name;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public PresetDesignTypeInputTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof PresetDesignTypeInput && equalTo((PresetDesignTypeInput) other);
    }

    private boolean equalTo(PresetDesignTypeInput other) {
        return
            name.equals(other.name) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.name,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "PresetDesignTypeInput{" +
               "name=" + name +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private PresetDesignTypeNameEnum name = null;
        private PresetDesignTypeInputTypeEnum type = null;

        private Builder() {}

        public Builder from(PresetDesignTypeInput other) {
            name(other.getName());
            type(other.getType());
            return this;
        }

        @JsonSetter("name")
        public Builder name(PresetDesignTypeNameEnum name) {
            if (name == null) {
                throw new IllegalArgumentException("name cannot be null");
            }

            this.name = name;
            return this;
        }


        @JsonSetter("type")
        public Builder type(PresetDesignTypeInputTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public PresetDesignTypeInput build() {
            if (name == null) {
                throw new IllegalStateException("name is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new PresetDesignTypeInput(
                       name,
                       type
                   );
        }
    }

}




