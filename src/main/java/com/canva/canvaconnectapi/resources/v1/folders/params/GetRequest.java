package com.canva.canvaconnectapi.resources.v1.folders.params;

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
    private final String folderId;

    private GetRequest(
        String folderId
    ) {
        this.folderId = folderId;
    }

    @JsonProperty("folderId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getFolderId() {
        return folderId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            folderId.equals(other.folderId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.folderId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "folderId=" + folderId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String folderId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            folderId(other.getFolderId());
            return this;
        }

        @JsonSetter("folderId")
        public Builder folderId(String folderId) {
            if (folderId == null) {
                throw new IllegalArgumentException("folderId cannot be null");
            }

            this.folderId = folderId;
            return this;
        }



        public GetRequest build() {
            if (folderId == null) {
                throw new IllegalStateException("folderId is required");
            }

            return new GetRequest(
                       folderId
                   );
        }
    }

}




