package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateFolderRequest.Builder.class)
public final class UpdateFolderRequest {
    /**
     * The folder name, as shown in the Canva UI.
     */
    private final String name;

    private UpdateFolderRequest(
        String name
    ) {
        this.name = name;
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UpdateFolderRequest && equalTo((UpdateFolderRequest) other);
    }

    private boolean equalTo(UpdateFolderRequest other) {
        return
            name.equals(other.name)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.name
               );
    }

    @Override
    public String toString() {
        return "UpdateFolderRequest{" +
               "name=" + name +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String name = null;

        private Builder() {}

        public Builder from(UpdateFolderRequest other) {
            name(other.getName());
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



        public UpdateFolderRequest build() {
            if (name == null) {
                throw new IllegalStateException("name is required");
            }

            return new UpdateFolderRequest(
                       name
                   );
        }
    }

}




