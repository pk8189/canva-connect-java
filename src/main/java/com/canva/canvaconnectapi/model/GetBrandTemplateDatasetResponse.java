package com.canva.canvaconnectapi.model;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetBrandTemplateDatasetResponse.Builder.class)
public final class GetBrandTemplateDatasetResponse {
    /**
     * The dataset definition for the brand template. The dataset definition contains the data inputs available for use with the
     * [Create design autofill job API](https://www.canva.dev/docs/connect/api-reference/autofills/create-design-autofill-job/).
     */
    private final Optional<GetBrandTemplateDatasetResponseDataset> dataset;

    private GetBrandTemplateDatasetResponse(
        Optional<GetBrandTemplateDatasetResponseDataset> dataset
    ) {
        this.dataset = dataset;
    }

    @JsonProperty("dataset")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public GetBrandTemplateDatasetResponseDataset getDataset() {
        return dataset.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetBrandTemplateDatasetResponse &&
               equalTo((GetBrandTemplateDatasetResponse) other);
    }

    private boolean equalTo(GetBrandTemplateDatasetResponse other) {
        return
            dataset.equals(other.dataset)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.dataset
               );
    }

    @Override
    public String toString() {
        return "GetBrandTemplateDatasetResponse{" +
               "dataset=" + dataset +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<GetBrandTemplateDatasetResponseDataset> dataset = Optional.empty();

        private Builder() {}

        public Builder from(GetBrandTemplateDatasetResponse other) {
            dataset(other.getDataset());
            return this;
        }

        @JsonSetter("dataset")
        public Builder dataset(GetBrandTemplateDatasetResponseDataset dataset) {
            this.dataset = Optional.ofNullable(dataset);
            return this;
        }

        public Builder dataset(Optional<GetBrandTemplateDatasetResponseDataset> dataset) {
            this.dataset = dataset;
            return this;
        }


        public GetBrandTemplateDatasetResponse build() {
            return new GetBrandTemplateDatasetResponse(
                       dataset
                   );
        }
    }

}




