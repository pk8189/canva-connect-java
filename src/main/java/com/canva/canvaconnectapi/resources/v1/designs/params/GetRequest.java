package com.canva.canvaconnectapi.resources.v1.designs.params;

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
    private final String designId;

    private GetRequest(
        String designId
    ) {
        this.designId = designId;
    }

    @JsonProperty("designId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDesignId() {
        return designId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            designId.equals(other.designId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.designId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "designId=" + designId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String designId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            designId(other.getDesignId());
            return this;
        }

        @JsonSetter("designId")
        public Builder designId(String designId) {
            if (designId == null) {
                throw new IllegalArgumentException("designId cannot be null");
            }

            this.designId = designId;
            return this;
        }



        public GetRequest build() {
            if (designId == null) {
                throw new IllegalStateException("designId is required");
            }

            return new GetRequest(
                       designId
                   );
        }
    }

}




