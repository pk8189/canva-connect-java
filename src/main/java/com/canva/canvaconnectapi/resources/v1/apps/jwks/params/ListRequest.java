package com.canva.canvaconnectapi.resources.v1.apps.jwks.params;

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
    private final String appId;

    private ListRequest(
        String appId
    ) {
        this.appId = appId;
    }

    @JsonProperty("appId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAppId() {
        return appId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ListRequest && equalTo((ListRequest) other);
    }

    private boolean equalTo(ListRequest other) {
        return
            appId.equals(other.appId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.appId
               );
    }

    @Override
    public String toString() {
        return "ListRequest{" +
               "appId=" + appId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String appId = null;

        private Builder() {}

        public Builder from(ListRequest other) {
            appId(other.getAppId());
            return this;
        }

        @JsonSetter("appId")
        public Builder appId(String appId) {
            if (appId == null) {
                throw new IllegalArgumentException("appId cannot be null");
            }

            this.appId = appId;
            return this;
        }



        public ListRequest build() {
            if (appId == null) {
                throw new IllegalStateException("appId is required");
            }

            return new ListRequest(
                       appId
                   );
        }
    }

}




