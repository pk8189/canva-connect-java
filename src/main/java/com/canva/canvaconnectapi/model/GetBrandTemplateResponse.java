package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetBrandTemplateResponse.Builder.class)
public final class GetBrandTemplateResponse {
    private final BrandTemplate brandTemplate;

    private GetBrandTemplateResponse(
        BrandTemplate brandTemplate
    ) {
        this.brandTemplate = brandTemplate;
    }

    @JsonProperty("brand_template")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public BrandTemplate getBrandTemplate() {
        return brandTemplate;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetBrandTemplateResponse && equalTo((GetBrandTemplateResponse) other);
    }

    private boolean equalTo(GetBrandTemplateResponse other) {
        return
            brandTemplate.equals(other.brandTemplate)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.brandTemplate
               );
    }

    @Override
    public String toString() {
        return "GetBrandTemplateResponse{" +
               "brandTemplate=" + brandTemplate +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private BrandTemplate brandTemplate = null;

        private Builder() {}

        public Builder from(GetBrandTemplateResponse other) {
            brandTemplate(other.getBrandTemplate());
            return this;
        }

        @JsonSetter("brand_template")
        public Builder brandTemplate(BrandTemplate brandTemplate) {
            if (brandTemplate == null) {
                throw new IllegalArgumentException("brandTemplate cannot be null");
            }

            this.brandTemplate = brandTemplate;
            return this;
        }



        public GetBrandTemplateResponse build() {
            if (brandTemplate == null) {
                throw new IllegalStateException("brandTemplate is required");
            }

            return new GetBrandTemplateResponse(
                       brandTemplate
                   );
        }
    }

}




