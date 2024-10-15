package com.canva.canvaconnectapi.resources.v1.folders.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.UpdateFolderRequest;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PatchRequest.Builder.class)
public final class PatchRequest {
    private final String folderId;
    private final UpdateFolderRequest data;

    private PatchRequest(
        String folderId,
        UpdateFolderRequest data
    ) {
        this.folderId = folderId;
        this.data = data;
    }

    @JsonProperty("folderId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getFolderId() {
        return folderId;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public UpdateFolderRequest getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof PatchRequest && equalTo((PatchRequest) other);
    }

    private boolean equalTo(PatchRequest other) {
        return
            folderId.equals(other.folderId) &&

            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.folderId,
                   this.data
               );
    }

    @Override
    public String toString() {
        return "PatchRequest{" +
               "folderId=" + folderId +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String folderId = null;
        private UpdateFolderRequest data = null;

        private Builder() {}

        public Builder from(PatchRequest other) {
            folderId(other.getFolderId());
            data(other.getData());
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


        @JsonSetter("data")
        public Builder data(UpdateFolderRequest data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public PatchRequest build() {
            if (folderId == null) {
                throw new IllegalStateException("folderId is required");
            }

            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new PatchRequest(
                       folderId,
                       data
                   );
        }
    }

}




