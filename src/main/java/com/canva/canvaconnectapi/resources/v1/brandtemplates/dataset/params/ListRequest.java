package com.canva.canvaconnectapi.resources.v1.brandtemplates.dataset.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListRequest.Builder.class)
public final class ListRequest {
    private final String brandTemplateId;

    private ListRequest(
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

        return other instanceof ListRequest && equalTo((ListRequest) other);
    }

    private boolean equalTo(ListRequest other) {
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
        return "ListRequest{" +
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

        public Builder from(ListRequest other) {
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



        public ListRequest build() {
            if (brandTemplateId == null) {
                throw new IllegalStateException("brandTemplateId is required");
            }

            return new ListRequest(
                       brandTemplateId
                   );
        }
    }

}




