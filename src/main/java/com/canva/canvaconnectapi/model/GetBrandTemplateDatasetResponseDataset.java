package com.canva.canvaconnectapi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetBrandTemplateDatasetResponseDataset.Builder.class)
public final class GetBrandTemplateDatasetResponseDataset {
    private final Map<String, DataField> additionalProperties;

    private GetBrandTemplateDatasetResponseDataset(

        Map<String, DataField> additionalProperties
    ) {
        this.additionalProperties = additionalProperties;
    }

    @JsonAnyGetter
    public Map<String, DataField> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetBrandTemplateDatasetResponseDataset &&
               equalTo((GetBrandTemplateDatasetResponseDataset) other);
    }

    private boolean equalTo(GetBrandTemplateDatasetResponseDataset other) {
        return
            additionalProperties.equals(other.additionalProperties)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(

                   this.additionalProperties
               );
    }

    @Override
    public String toString() {
        return "GetBrandTemplateDatasetResponseDataset{" +
               ", additionalProperties=" + additionalProperties +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<String, DataField> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetBrandTemplateDatasetResponseDataset other) {
            additionalProperties(other.getAdditionalProperties());
            return this;
        }

        @JsonAnySetter
        public Builder additionalProperty(String key, DataField value) {
            this.additionalProperties.put(key, value);
            return this;
        }

        public Builder additionalProperties(Map<String, DataField> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        public GetBrandTemplateDatasetResponseDataset build() {
            return new GetBrandTemplateDatasetResponseDataset(

                       additionalProperties
                   );
        }
    }

}




