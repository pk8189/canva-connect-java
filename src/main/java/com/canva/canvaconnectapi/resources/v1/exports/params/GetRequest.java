package com.canva.canvaconnectapi.resources.v1.exports.params;

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
    private final String exportId;

    private GetRequest(
        String exportId
    ) {
        this.exportId = exportId;
    }

    @JsonProperty("exportId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getExportId() {
        return exportId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            exportId.equals(other.exportId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.exportId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "exportId=" + exportId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String exportId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            exportId(other.getExportId());
            return this;
        }

        @JsonSetter("exportId")
        public Builder exportId(String exportId) {
            if (exportId == null) {
                throw new IllegalArgumentException("exportId cannot be null");
            }

            this.exportId = exportId;
            return this;
        }



        public GetRequest build() {
            if (exportId == null) {
                throw new IllegalStateException("exportId is required");
            }

            return new GetRequest(
                       exportId
                   );
        }
    }

}




