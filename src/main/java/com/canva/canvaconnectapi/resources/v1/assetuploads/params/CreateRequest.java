package com.canva.canvaconnectapi.resources.v1.assetuploads.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.AssetUploadMetadata;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateRequest.Builder.class)
public final class CreateRequest {
    private final AssetUploadMetadata assetUploadMetadata;
    private final java.io.File data;

    private CreateRequest(
        AssetUploadMetadata assetUploadMetadata,
        java.io.File data
    ) {
        this.assetUploadMetadata = assetUploadMetadata;
        this.data = data;
    }

    @JsonProperty("assetUploadMetadata")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetUploadMetadata getAssetUploadMetadata() {
        return assetUploadMetadata;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public java.io.File getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateRequest && equalTo((CreateRequest) other);
    }

    private boolean equalTo(CreateRequest other) {
        return
            assetUploadMetadata.equals(other.assetUploadMetadata) &&

            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assetUploadMetadata,
                   this.data
               );
    }

    @Override
    public String toString() {
        return "CreateRequest{" +
               "assetUploadMetadata=" + assetUploadMetadata +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private AssetUploadMetadata assetUploadMetadata = null;
        private java.io.File data = null;

        private Builder() {}

        public Builder from(CreateRequest other) {
            assetUploadMetadata(other.getAssetUploadMetadata());
            data(other.getData());
            return this;
        }

        @JsonSetter("assetUploadMetadata")
        public Builder assetUploadMetadata(AssetUploadMetadata assetUploadMetadata) {
            if (assetUploadMetadata == null) {
                throw new IllegalArgumentException("assetUploadMetadata cannot be null");
            }

            this.assetUploadMetadata = assetUploadMetadata;
            return this;
        }


        @JsonSetter("data")
        public Builder data(java.io.File data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public CreateRequest build() {
            if (assetUploadMetadata == null) {
                throw new IllegalStateException("assetUploadMetadata is required");
            }

            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new CreateRequest(
                       assetUploadMetadata,
                       data
                   );
        }
    }

}




