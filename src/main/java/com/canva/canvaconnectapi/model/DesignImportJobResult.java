package com.canva.canvaconnectapi.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DesignImportJobResult.Builder.class)
public final class DesignImportJobResult {
    /**
     * A list of designs imported from the external file. It usually contains one item.
     * Imports with a large number of pages or assets are split into multiple designs.
     */
    private final List<DesignSummary> designs;

    private DesignImportJobResult(
        List<DesignSummary> designs
    ) {
        this.designs = designs;
    }

    @JsonProperty("designs")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<DesignSummary> getDesigns() {
        return designs;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignImportJobResult && equalTo((DesignImportJobResult) other);
    }

    private boolean equalTo(DesignImportJobResult other) {
        return
            designs.equals(other.designs)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.designs
               );
    }

    @Override
    public String toString() {
        return "DesignImportJobResult{" +
               "designs=" + designs +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<DesignSummary> designs = null;

        private Builder() {}

        public Builder from(DesignImportJobResult other) {
            designs(other.getDesigns());
            return this;
        }

        @JsonSetter("designs")
        public Builder designs(List<DesignSummary> designs) {
            if (designs == null) {
                throw new IllegalArgumentException("designs cannot be null");
            }

            this.designs = designs;
            return this;
        }



        public DesignImportJobResult build() {
            if (designs == null) {
                throw new IllegalStateException("designs is required");
            }

            return new DesignImportJobResult(
                       designs
                   );
        }
    }

}




