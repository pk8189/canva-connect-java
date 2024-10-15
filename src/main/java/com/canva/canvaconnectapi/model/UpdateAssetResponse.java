package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateAssetResponse.Builder.class)
public final class UpdateAssetResponse {
    private final Asset asset;

    private UpdateAssetResponse(
        Asset asset
    ) {
        this.asset = asset;
    }

    @JsonProperty("asset")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Asset getAsset() {
        return asset;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UpdateAssetResponse && equalTo((UpdateAssetResponse) other);
    }

    private boolean equalTo(UpdateAssetResponse other) {
        return
            asset.equals(other.asset)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.asset
               );
    }

    @Override
    public String toString() {
        return "UpdateAssetResponse{" +
               "asset=" + asset +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Asset asset = null;

        private Builder() {}

        public Builder from(UpdateAssetResponse other) {
            asset(other.getAsset());
            return this;
        }

        @JsonSetter("asset")
        public Builder asset(Asset asset) {
            if (asset == null) {
                throw new IllegalArgumentException("asset cannot be null");
            }

            this.asset = asset;
            return this;
        }



        public UpdateAssetResponse build() {
            if (asset == null) {
                throw new IllegalStateException("asset is required");
            }

            return new UpdateAssetResponse(
                       asset
                   );
        }
    }

}




