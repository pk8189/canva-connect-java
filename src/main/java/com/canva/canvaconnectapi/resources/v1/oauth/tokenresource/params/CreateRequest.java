package com.canva.canvaconnectapi.resources.v1.oauth.tokenresource.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.ExchangeAccessTokenRequest;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateRequest.Builder.class)
public final class CreateRequest {
    private final ExchangeAccessTokenRequest data;

    private CreateRequest(
        ExchangeAccessTokenRequest data
    ) {
        this.data = data;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExchangeAccessTokenRequest getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateRequest && equalTo((CreateRequest) other);
    }

    private boolean equalTo(CreateRequest other) {
        return
            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.data
               );
    }

    @Override
    public String toString() {
        return "CreateRequest{" +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ExchangeAccessTokenRequest data = null;

        private Builder() {}

        public Builder from(CreateRequest other) {
            data(other.getData());
            return this;
        }

        @JsonSetter("data")
        public Builder data(ExchangeAccessTokenRequest data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public CreateRequest build() {
            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new CreateRequest(
                       data
                   );
        }
    }

}




