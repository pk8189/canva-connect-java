package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetDesignResponse.Builder.class)
public final class GetDesignResponse {
    private final Design design;

    private GetDesignResponse(
        Design design
    ) {
        this.design = design;
    }

    @JsonProperty("design")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Design getDesign() {
        return design;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetDesignResponse && equalTo((GetDesignResponse) other);
    }

    private boolean equalTo(GetDesignResponse other) {
        return
            design.equals(other.design)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.design
               );
    }

    @Override
    public String toString() {
        return "GetDesignResponse{" +
               "design=" + design +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Design design = null;

        private Builder() {}

        public Builder from(GetDesignResponse other) {
            design(other.getDesign());
            return this;
        }

        @JsonSetter("design")
        public Builder design(Design design) {
            if (design == null) {
                throw new IllegalArgumentException("design cannot be null");
            }

            this.design = design;
            return this;
        }



        public GetDesignResponse build() {
            if (design == null) {
                throw new IllegalStateException("design is required");
            }

            return new GetDesignResponse(
                       design
                   );
        }
    }

}




