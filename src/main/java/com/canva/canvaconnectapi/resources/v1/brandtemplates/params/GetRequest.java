package com.canva.canvaconnectapi.resources.v1.brandtemplates.params;

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
    private final String brandTemplateId;

    private GetRequest(
        String brandTemplateId
    ) {
        this.brandTemplateId = brandTemplateId;
    }

    @JsonProperty("brandTemplateId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getBrandTemplateId() {
        return brandTemplateId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            brandTemplateId.equals(other.brandTemplateId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.brandTemplateId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "brandTemplateId=" + brandTemplateId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String brandTemplateId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            brandTemplateId(other.getBrandTemplateId());
            return this;
        }

        @JsonSetter("brandTemplateId")
        public Builder brandTemplateId(String brandTemplateId) {
            if (brandTemplateId == null) {
                throw new IllegalArgumentException("brandTemplateId cannot be null");
            }

            this.brandTemplateId = brandTemplateId;
            return this;
        }



        public GetRequest build() {
            if (brandTemplateId == null) {
                throw new IllegalStateException("brandTemplateId is required");
            }

            return new GetRequest(
                       brandTemplateId
                   );
        }
    }

}




