package com.canva.canvaconnectapi.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetAppJwksResponse.Builder.class)
public final class GetAppJwksResponse {
    /**
     * The value of the &quot;keys&quot; parameter is an array of JWK values. The order of keys has no
     * meaning.
     */
    private final List<JsonWebKey> keys;

    private GetAppJwksResponse(
        List<JsonWebKey> keys
    ) {
        this.keys = keys;
    }

    @JsonProperty("keys")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<JsonWebKey> getKeys() {
        return keys;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetAppJwksResponse && equalTo((GetAppJwksResponse) other);
    }

    private boolean equalTo(GetAppJwksResponse other) {
        return
            keys.equals(other.keys)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.keys
               );
    }

    @Override
    public String toString() {
        return "GetAppJwksResponse{" +
               "keys=" + keys +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<JsonWebKey> keys = null;

        private Builder() {}

        public Builder from(GetAppJwksResponse other) {
            keys(other.getKeys());
            return this;
        }

        @JsonSetter("keys")
        public Builder keys(List<JsonWebKey> keys) {
            if (keys == null) {
                throw new IllegalArgumentException("keys cannot be null");
            }

            this.keys = keys;
            return this;
        }



        public GetAppJwksResponse build() {
            if (keys == null) {
                throw new IllegalStateException("keys is required");
            }

            return new GetAppJwksResponse(
                       keys
                   );
        }
    }

}




