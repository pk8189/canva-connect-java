package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetFolderResponse.Builder.class)
public final class GetFolderResponse {
    private final Folder folder;

    private GetFolderResponse(
        Folder folder
    ) {
        this.folder = folder;
    }

    @JsonProperty("folder")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Folder getFolder() {
        return folder;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetFolderResponse && equalTo((GetFolderResponse) other);
    }

    private boolean equalTo(GetFolderResponse other) {
        return
            folder.equals(other.folder)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.folder
               );
    }

    @Override
    public String toString() {
        return "GetFolderResponse{" +
               "folder=" + folder +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Folder folder = null;

        private Builder() {}

        public Builder from(GetFolderResponse other) {
            folder(other.getFolder());
            return this;
        }

        @JsonSetter("folder")
        public Builder folder(Folder folder) {
            if (folder == null) {
                throw new IllegalArgumentException("folder cannot be null");
            }

            this.folder = folder;
            return this;
        }



        public GetFolderResponse build() {
            if (folder == null) {
                throw new IllegalStateException("folder is required");
            }

            return new GetFolderResponse(
                       folder
                   );
        }
    }

}




