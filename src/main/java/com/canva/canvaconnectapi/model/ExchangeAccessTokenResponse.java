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
@JsonDeserialize(builder = ExchangeAccessTokenResponse.Builder.class)
public final class ExchangeAccessTokenResponse {
    /**
     * The bearer access token to use to authenticate to Canva Connect API endpoints. If requested using a &#x60;authorization_code&#x60; or &#x60;refresh_token&#x60;, this allows you to act on behalf of a user.
     */
    private final String accessToken;
    /**
     * The expiry time (in seconds) for the token.
     */
    private final Integer expiresIn;
    /**
     * The token that you can use to refresh the access token.
     */
    private final String refreshToken;
    /**
     * The [scopes](https://www.canva.dev/docs/connect/appendix/scopes/) that the token has been granted.
     */
    private final Optional<String> scope;
    /**
     * The token type returned. This is always &#x60;Bearer&#x60;.
     */
    private final String tokenType;

    private ExchangeAccessTokenResponse(
        String accessToken,
        Integer expiresIn,
        String refreshToken,
        Optional<String> scope,
        String tokenType
    ) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.tokenType = tokenType;
    }

    @JsonProperty("access_token")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("expires_in")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getExpiresIn() {
        return expiresIn;
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

    @JsonProperty("token_type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTokenType() {
        return tokenType;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ExchangeAccessTokenResponse && equalTo((ExchangeAccessTokenResponse) other);
    }

    private boolean equalTo(ExchangeAccessTokenResponse other) {
        return
            accessToken.equals(other.accessToken) &&

            expiresIn.equals(other.expiresIn) &&

            refreshToken.equals(other.refreshToken) &&

            scope.equals(other.scope) &&

            tokenType.equals(other.tokenType)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.accessToken,
                   this.expiresIn,
                   this.refreshToken,
                   this.scope,
                   this.tokenType
               );
    }

    @Override
    public String toString() {
        return "ExchangeAccessTokenResponse{" +
               "accessToken=" + accessToken +
               "expiresIn=" + expiresIn +
               "refreshToken=" + refreshToken +
               "scope=" + scope +
               "tokenType=" + tokenType +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String accessToken = null;
        private Integer expiresIn = null;
        private String refreshToken = null;
        private Optional<String> scope = Optional.empty();
        private String tokenType = null;

        private Builder() {}

        public Builder from(ExchangeAccessTokenResponse other) {
            accessToken(other.getAccessToken());
            expiresIn(other.getExpiresIn());
            refreshToken(other.getRefreshToken());
            scope(other.getScope());
            tokenType(other.getTokenType());
            return this;
        }

        @JsonSetter("access_token")
        public Builder accessToken(String accessToken) {
            if (accessToken == null) {
                throw new IllegalArgumentException("accessToken cannot be null");
            }

            this.accessToken = accessToken;
            return this;
        }


        @JsonSetter("expires_in")
        public Builder expiresIn(Integer expiresIn) {
            if (expiresIn == null) {
                throw new IllegalArgumentException("expiresIn cannot be null");
            }

            this.expiresIn = expiresIn;
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

        @JsonSetter("token_type")
        public Builder tokenType(String tokenType) {
            if (tokenType == null) {
                throw new IllegalArgumentException("tokenType cannot be null");
            }

            this.tokenType = tokenType;
            return this;
        }



        public ExchangeAccessTokenResponse build() {
            if (accessToken == null) {
                throw new IllegalStateException("accessToken is required");
            }

            if (expiresIn == null) {
                throw new IllegalStateException("expiresIn is required");
            }

            if (refreshToken == null) {
                throw new IllegalStateException("refreshToken is required");
            }

            if (tokenType == null) {
                throw new IllegalStateException("tokenType is required");
            }

            return new ExchangeAccessTokenResponse(
                       accessToken,
                       expiresIn,
                       refreshToken,
                       scope,
                       tokenType
                   );
        }
    }

}




