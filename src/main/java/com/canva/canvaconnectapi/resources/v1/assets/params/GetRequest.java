package com.canva.canvaconnectapi.resources.v1.assets.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetRequest.Builder.class)
public final class GetRequest {
    private final String assetId;

    private GetRequest(
        String assetId
    ) {
        this.assetId = assetId;
    }

    @JsonProperty("assetId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAssetId() {
        return assetId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            assetId.equals(other.assetId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assetId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "assetId=" + assetId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String assetId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            assetId(other.getAssetId());
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



        public GetRequest build() {
            if (assetId == null) {
                throw new IllegalStateException("assetId is required");
            }

            return new GetRequest(
                       assetId
                   );
        }
    }

}




