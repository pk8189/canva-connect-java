package com.canva.canvaconnectapi.model;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = IntrospectTokenRequest.Builder.class)
public final class IntrospectTokenRequest {
    /**
     * Your integration&#x27;s unique ID, for authenticating the request.
     *
     * NOTE: We recommend that you use basic access authentication instead of specifying &#x60;client_id&#x60; and &#x60;client_secret&#x60; as body parameters.
     *
     */
    private final Optional<String> clientId;
    /**
     * Your integration&#x27;s client secret, for authenticating the request. Begins with &#x60;cnvca&#x60;.
     *
     * NOTE: We recommend that you use basic access authentication instead of specifying &#x60;client_id&#x60; and &#x60;client_secret&#x60; as body parameters.
     *
     */
    private final Optional<String> clientSecret;
    /**
     * The token to introspect.
     */
    private final String token;

    private IntrospectTokenRequest(
        Optional<String> clientId,
        Optional<String> clientSecret,
        String token
    ) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.token = token;
    }

    @JsonProperty("client_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getClientId() {
        return clientId.orElse(null);
    }

    @JsonProperty("client_secret")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getClientSecret() {
        return clientSecret.orElse(null);
    }

    @JsonProperty("token")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getToken() {
        return token;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof IntrospectTokenRequest && equalTo((IntrospectTokenRequest) other);
    }

    private boolean equalTo(IntrospectTokenRequest other) {
        return
            clientId.equals(other.clientId) &&

            clientSecret.equals(other.clientSecret) &&

            token.equals(other.token)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.clientId,
                   this.clientSecret,
                   this.token
               );
    }

    @Override
    public String toString() {
        return "IntrospectTokenRequest{" +
               "clientId=" + clientId +
               "clientSecret=" + clientSecret +
               "token=" + token +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> clientId = Optional.empty();
        private Optional<String> clientSecret = Optional.empty();
        private String token = null;

        private Builder() {}

        public Builder from(IntrospectTokenRequest other) {
            clientId(other.getClientId());
            clientSecret(other.getClientSecret());
            token(other.getToken());
            return this;
        }

        @JsonSetter("client_id")
        public Builder clientId(String clientId) {
            this.clientId = Optional.ofNullable(clientId);
            return this;
        }

        public Builder clientId(Optional<String> clientId) {
            this.clientId = clientId;
            return this;
        }

        @JsonSetter("client_secret")
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = Optional.ofNullable(clientSecret);
            return this;
        }

        public Builder clientSecret(Optional<String> clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        @JsonSetter("token")
        public Builder token(String token) {
            if (token == null) {
                throw new IllegalArgumentException("token cannot be null");
            }

            this.token = token;
            return this;
        }



        public IntrospectTokenRequest build() {
            if (token == null) {
                throw new IllegalStateException("token is required");
            }

            return new IntrospectTokenRequest(
                       clientId,
                       clientSecret,
                       token
                   );
        }
    }

}




