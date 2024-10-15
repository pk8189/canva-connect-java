package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DesignItem.Builder.class)
public final class DesignItem {
    private final DesignSummary design;
    private final DesignItemTypeEnum type;

    private DesignItem(
        DesignSummary design,
        DesignItemTypeEnum type
    ) {
        this.design = design;
        this.type = type;
    }

    @JsonProperty("design")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignSummary getDesign() {
        return design;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignItemTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignItem && equalTo((DesignItem) other);
    }

    private boolean equalTo(DesignItem other) {
        return
            design.equals(other.design) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.design,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "DesignItem{" +
               "design=" + design +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DesignSummary design = null;
        private DesignItemTypeEnum type = null;

        private Builder() {}

        public Builder from(DesignItem other) {
            design(other.getDesign());
            type(other.getType());
            return this;
        }

        @JsonSetter("design")
        public Builder design(DesignSummary design) {
            if (design == null) {
                throw new IllegalArgumentException("design cannot be null");
            }

            this.design = design;
            return this;
        }


        @JsonSetter("type")
        public Builder type(DesignItemTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public DesignItem build() {
            if (design == null) {
                throw new IllegalStateException("design is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DesignItem(
                       design,
                       type
                   );
        }
    }

}




