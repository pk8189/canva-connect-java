package com.canva.canvaconnectapi.resources.v1.imports.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.DesignImportMetadata;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateRequest.Builder.class)
public final class CreateRequest {
    private final DesignImportMetadata importMetadata;
    private final java.io.File data;

    private CreateRequest(
        DesignImportMetadata importMetadata,
        java.io.File data
    ) {
        this.importMetadata = importMetadata;
        this.data = data;
    }

    @JsonProperty("importMetadata")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignImportMetadata getImportMetadata() {
        return importMetadata;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public java.io.File getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateRequest && equalTo((CreateRequest) other);
    }

    private boolean equalTo(CreateRequest other) {
        return
            importMetadata.equals(other.importMetadata) &&

            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.importMetadata,
                   this.data
               );
    }

    @Override
    public String toString() {
        return "CreateRequest{" +
               "importMetadata=" + importMetadata +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DesignImportMetadata importMetadata = null;
        private java.io.File data = null;

        private Builder() {}

        public Builder from(CreateRequest other) {
            importMetadata(other.getImportMetadata());
            data(other.getData());
            return this;
        }

        @JsonSetter("importMetadata")
        public Builder importMetadata(DesignImportMetadata importMetadata) {
            if (importMetadata == null) {
                throw new IllegalArgumentException("importMetadata cannot be null");
            }

            this.importMetadata = importMetadata;
            return this;
        }


        @JsonSetter("data")
        public Builder data(java.io.File data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public CreateRequest build() {
            if (importMetadata == null) {
                throw new IllegalStateException("importMetadata is required");
            }

            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new CreateRequest(
                       importMetadata,
                       data
                   );
        }
    }

}




