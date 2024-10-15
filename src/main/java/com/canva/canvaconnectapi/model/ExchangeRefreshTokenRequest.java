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
@JsonDeserialize(builder = ExchangeRefreshTokenRequest.Builder.class)
public final class ExchangeRefreshTokenRequest {
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
     * For generating an access token using a refresh token.
     */
    private final ExchangeRefreshTokenRequestGrantTypeEnum grantType;
    /**
     * The refresh token to be exchanged. You can copy this value from the successful response received when generating an access token.
     */
    private final String refreshToken;
    /**
     * Optional scope value when refreshing an access token. Separate multiple [scopes](https://www.canva.dev/docs/connect/appendix/scopes/) with a single space between each scope.
     *
     * The requested scope cannot include any permissions not already granted, so this parameter allows you to limit the scope when refreshing a token. If omitted, the scope for the token remains unchanged.
     *
     */
    private final Optional<String> scope;

    private ExchangeRefreshTokenRequest(
        Optional<String> clientId,
        Optional<String> clientSecret,
        ExchangeRefreshTokenRequestGrantTypeEnum grantType,
        String refreshToken,
        Optional<String> scope
    ) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.refreshToken = refreshToken;
        this.scope = scope;
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

    @JsonProperty("grant_type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExchangeRefreshTokenRequestGrantTypeEnum getGrantType() {
        return grantType;
    }

    @JsonProperty("refresh_token")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("scope")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getScope() {
        return scope.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ExchangeRefreshTokenRequest && equalTo((ExchangeRefreshTokenRequest) other);
    }

    private boolean equalTo(ExchangeRefreshTokenRequest other) {
        return
            clientId.equals(other.clientId) &&

            clientSecret.equals(other.clientSecret) &&

            grantType.equals(other.grantType) &&

            refreshToken.equals(other.refreshToken) &&

            scope.equals(other.scope)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.clientId,
                   this.clientSecret,
                   this.grantType,
                   this.refreshToken,
                   this.scope
               );
    }

    @Override
    public String toString() {
        return "ExchangeRefreshTokenRequest{" +
               "clientId=" + clientId +
               "clientSecret=" + clientSecret +
               "grantType=" + grantType +
               "refreshToken=" + refreshToken +
               "scope=" + scope +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> clientId = Optional.empty();
        private Optional<String> clientSecret = Optional.empty();
        private ExchangeRefreshTokenRequestGrantTypeEnum grantType = null;
        private String refreshToken = null;
        private Optional<String> scope = Optional.empty();

        private Builder() {}

        public Builder from(ExchangeRefreshTokenRequest other) {
            clientId(other.getClientId());
            clientSecret(other.getClientSecret());
            grantType(other.getGrantType());
            refreshToken(other.getRefreshToken());
            scope(other.getScope());
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

        @JsonSetter("grant_type")
        public Builder grantType(ExchangeRefreshTokenRequestGrantTypeEnum grantType) {
            if (grantType == null) {
                throw new IllegalArgumentException("grantType cannot be null");
            }

            this.grantType = grantType;
            return this;
        }


        @JsonSetter("refresh_token")
        public Builder refreshToken(String refreshToken) {
            if (refreshToken == null) {
                throw new IllegalArgumentException("refreshToken cannot be null");
            }

            this.refreshToken = refreshToken;
            return this;
        }


        @JsonSetter("scope")
        public Builder scope(String scope) {
            this.scope = Optional.ofNullable(scope);
            return this;
        }

        public Builder scope(Optional<String> scope) {
            this.scope = scope;
            return this;
        }


        public ExchangeRefreshTokenRequest build() {
            if (grantType == null) {
                throw new IllegalStateException("grantType is required");
            }

            if (refreshToken == null) {
                throw new IllegalStateException("refreshToken is required");
            }

            return new ExchangeRefreshTokenRequest(
                       clientId,
                       clientSecret,
                       grantType,
                       refreshToken,
                       scope
                   );
        }
    }

}




