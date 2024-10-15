package com.canva.canvaconnectapi.resources.v1.assets.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.UpdateAssetRequest;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PatchRequest.Builder.class)
public final class PatchRequest {
    private final String assetId;
    private final UpdateAssetRequest data;

    private PatchRequest(
        String assetId,
        UpdateAssetRequest data
    ) {
        this.assetId = assetId;
        this.data = data;
    }

    @JsonProperty("assetId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAssetId() {
        return assetId;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public UpdateAssetRequest getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof PatchRequest && equalTo((PatchRequest) other);
    }

    private boolean equalTo(PatchRequest other) {
        return
            assetId.equals(other.assetId) &&

            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assetId,
                   this.data
               );
    }

    @Override
    public String toString() {
        return "PatchRequest{" +
               "assetId=" + assetId +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String assetId = null;
        private UpdateAssetRequest data = null;

        private Builder() {}

        public Builder from(PatchRequest other) {
            assetId(other.getAssetId());
            data(other.getData());
            return this;
        }

        @JsonSetter("assetId")
        public Builder assetId(String assetId) {
            if (assetId == null) {
                throw new IllegalArgumentException("assetId cannot be null");
            }

            this.assetId = assetId;
            return this;
        }


        @JsonSetter("data")
        public Builder data(UpdateAssetRequest data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public PatchRequest build() {
            if (assetId == null) {
                throw new IllegalStateException("assetId is required");
            }

            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new PatchRequest(
                       assetId,
                       data
                   );
        }
    }

}




