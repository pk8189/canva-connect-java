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
@JsonDeserialize(builder = UpdateFolderResponse.Builder.class)
public final class UpdateFolderResponse {
    private final Optional<Folder> folder;

    private UpdateFolderResponse(
        Optional<Folder> folder
    ) {
        this.folder = folder;
    }

    @JsonProperty("folder")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Folder getFolder() {
        return folder.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UpdateFolderResponse && equalTo((UpdateFolderResponse) other);
    }

    private boolean equalTo(UpdateFolderResponse other) {
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
        return "UpdateFolderResponse{" +
               "folder=" + folder +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Folder> folder = Optional.empty();

        private Builder() {}

        public Builder from(UpdateFolderResponse other) {
            folder(other.getFolder());
            return this;
        }

        @JsonSetter("folder")
        public Builder folder(Folder folder) {
            this.folder = Optional.ofNullable(folder);
            return this;
        }

        public Builder folder(Optional<Folder> folder) {
            this.folder = folder;
            return this;
        }


        public UpdateFolderResponse build() {
            return new UpdateFolderResponse(
                       folder
                   );
        }
    }

}




