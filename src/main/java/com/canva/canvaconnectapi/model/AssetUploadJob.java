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
@JsonDeserialize(builder = AssetUploadJob.Builder.class)
public final class AssetUploadJob {
    private final Optional<Asset> asset;
    private final Optional<AssetUploadError> error;
    /**
     * The ID of the asset upload job.
     */
    private final String id;
    private final AssetUploadStatusEnum status;

    private AssetUploadJob(
        Optional<Asset> asset,
        Optional<AssetUploadError> error,
        String id,
        AssetUploadStatusEnum status
    ) {
        this.asset = asset;
        this.error = error;
        this.id = id;
        this.status = status;
    }

    @JsonProperty("asset")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Asset getAsset() {
        return asset.orElse(null);
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetUploadError getError() {
        return error.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetUploadStatusEnum getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof AssetUploadJob && equalTo((AssetUploadJob) other);
    }

    private boolean equalTo(AssetUploadJob other) {
        return
            asset.equals(other.asset) &&

            error.equals(other.error) &&

            id.equals(other.id) &&

            status.equals(other.status)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.asset,
                   this.error,
                   this.id,
                   this.status
               );
    }

    @Override
    public String toString() {
        return "AssetUploadJob{" +
               "asset=" + asset +
               "error=" + error +
               "id=" + id +
               "status=" + status +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Asset> asset = Optional.empty();
        private Optional<AssetUploadError> error = Optional.empty();
        private String id = null;
        private AssetUploadStatusEnum status = null;

        private Builder() {}

        public Builder from(AssetUploadJob other) {
            asset(other.getAsset());
            error(other.getError());
            id(other.getId());
            status(other.getStatus());
            return this;
        }

        @JsonSetter("asset")
        public Builder asset(Asset asset) {
            this.asset = Optional.ofNullable(asset);
            return this;
        }

        public Builder asset(Optional<Asset> asset) {
            this.asset = asset;
            return this;
        }

        @JsonSetter("error")
        public Builder error(AssetUploadError error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<AssetUploadError> error) {
            this.error = error;
            return this;
        }

        @JsonSetter("id")
        public Builder id(String id) {
            if (id == null) {
                throw new IllegalArgumentException("id cannot be null");
            }

            this.id = id;
            return this;
        }


        @JsonSetter("status")
        public Builder status(AssetUploadStatusEnum status) {
            if (status == null) {
                throw new IllegalArgumentException("status cannot be null");
            }

            this.status = status;
            return this;
        }



        public AssetUploadJob build() {
            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (status == null) {
                throw new IllegalStateException("status is required");
            }

            return new AssetUploadJob(
                       asset,
                       error,
                       id,
                       status
                   );
        }
    }

}




