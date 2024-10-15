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
@JsonDeserialize(builder = GetSigningPublicKeysResponse.Builder.class)
public final class GetSigningPublicKeysResponse {
    /**
     * A Json Web Key Set (JWKS) with public keys used for signing webhooks. You can use this JWKS
     * to verify that a webhook was sent from Canva.
     */
    private final List<EdDsaJwk> keys;

    private GetSigningPublicKeysResponse(
        List<EdDsaJwk> keys
    ) {
        this.keys = keys;
    }

    @JsonProperty("keys")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<EdDsaJwk> getKeys() {
        return keys;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetSigningPublicKeysResponse &&
               equalTo((GetSigningPublicKeysResponse) other);
    }

    private boolean equalTo(GetSigningPublicKeysResponse other) {
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
        return "GetSigningPublicKeysResponse{" +
               "keys=" + keys +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<EdDsaJwk> keys = null;

        private Builder() {}

        public Builder from(GetSigningPublicKeysResponse other) {
            keys(other.getKeys());
            return this;
        }

        @JsonSetter("keys")
        public Builder keys(List<EdDsaJwk> keys) {
            if (keys == null) {
                throw new IllegalArgumentException("keys cannot be null");
            }

            this.keys = keys;
            return this;
        }



        public GetSigningPublicKeysResponse build() {
            if (keys == null) {
                throw new IllegalStateException("keys is required");
            }

            return new GetSigningPublicKeysResponse(
                       keys
                   );
        }
    }

}




