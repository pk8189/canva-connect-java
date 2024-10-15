package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateFolderRequest.Builder.class)
public final class CreateFolderRequest {
    /**
     * The name of the folder. Must be less than 256 characters.
     */
    private final String name;
    /**
     * The folder ID of the parent folder. To create a new folder at the top level of a user&#x27;s
     * [projects](https://www.canva.com/help/find-designs-and-folders/), use the ID &#x60;root&#x60;.
     */
    private final String parentFolderId;

    private CreateFolderRequest(
        String name,
        String parentFolderId
    ) {
        this.name = name;
        this.parentFolderId = parentFolderId;
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getName() {
        return name;
    }

    @JsonProperty("parent_folder_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getParentFolderId() {
        return parentFolderId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateFolderRequest && equalTo((CreateFolderRequest) other);
    }

    private boolean equalTo(CreateFolderRequest other) {
        return
            name.equals(other.name) &&

            parentFolderId.equals(other.parentFolderId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.name,
                   this.parentFolderId
               );
    }

    @Override
    public String toString() {
        return "CreateFolderRequest{" +
               "name=" + name +
               "parentFolderId=" + parentFolderId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String name = null;
        private String parentFolderId = null;

        private Builder() {}

        public Builder from(CreateFolderRequest other) {
            name(other.getName());
            parentFolderId(other.getParentFolderId());
            return this;
        }

        @JsonSetter("name")
        public Builder name(String name) {
            if (name == null) {
                throw new IllegalArgumentException("name cannot be null");
            }

            this.name = name;
            return this;
        }


        @JsonSetter("parent_folder_id")
        public Builder parentFolderId(String parentFolderId) {
            if (parentFolderId == null) {
                throw new IllegalArgumentException("parentFolderId cannot be null");
            }

            this.parentFolderId = parentFolderId;
            return this;
        }



        public CreateFolderRequest build() {
            if (name == null) {
                throw new IllegalStateException("name is required");
            }

            if (parentFolderId == null) {
                throw new IllegalStateException("parentFolderId is required");
            }

            return new CreateFolderRequest(
                       name,
                       parentFolderId
                   );
        }
    }

}




