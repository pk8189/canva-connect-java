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
@JsonDeserialize(builder = ExchangeAuthCodeRequest.Builder.class)
public final class ExchangeAuthCodeRequest {
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
     * The authorization code you received after the user authorized the integration.
     */
    private final String code;
    /**
     * The &#x60;code_verifier&#x60; value that you generated when creating the user authorization URL.
     */
    private final String codeVerifier;
    /**
     * For exchanging an authorization code for an access token.
     */
    private final ExchangeAuthCodeRequestGrantTypeEnum grantType;
    /**
     * Only required if a redirect URL was supplied when you [created the user authorization URL](https://www.canva.dev/docs/connect/authentication/#create-the-authorization-url).
     *
     * Must be one of those already specified by the client. If not supplied, the first redirect_uri defined for the client will be used by default.
     *
     */
    private final Optional<String> redirectUri;

    private ExchangeAuthCodeRequest(
        Optional<String> clientId,
        Optional<String> clientSecret,
        String code,
        String codeVerifier,
        ExchangeAuthCodeRequestGrantTypeEnum grantType,
        Optional<String> redirectUri
    ) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.codeVerifier = codeVerifier;
        this.grantType = grantType;
        this.redirectUri = redirectUri;
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

    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getCode() {
        return code;
    }

    @JsonProperty("code_verifier")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getCodeVerifier() {
        return codeVerifier;
    }

    @JsonProperty("grant_type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExchangeAuthCodeRequestGrantTypeEnum getGrantType() {
        return grantType;
    }

    @JsonProperty("redirect_uri")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getRedirectUri() {
        return redirectUri.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ExchangeAuthCodeRequest && equalTo((ExchangeAuthCodeRequest) other);
    }

    private boolean equalTo(ExchangeAuthCodeRequest other) {
        return
            clientId.equals(other.clientId) &&

            clientSecret.equals(other.clientSecret) &&

            code.equals(other.code) &&

            codeVerifier.equals(other.codeVerifier) &&

            grantType.equals(other.grantType) &&

            redirectUri.equals(other.redirectUri)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.clientId,
                   this.clientSecret,
                   this.code,
                   this.codeVerifier,
                   this.grantType,
                   this.redirectUri
               );
    }

    @Override
    public String toString() {
        return "ExchangeAuthCodeRequest{" +
               "clientId=" + clientId +
               "clientSecret=" + clientSecret +
               "code=" + code +
               "codeVerifier=" + codeVerifier +
               "grantType=" + grantType +
               "redirectUri=" + redirectUri +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> clientId = Optional.empty();
        private Optional<String> clientSecret = Optional.empty();
        private String code = null;
        private String codeVerifier = null;
        private ExchangeAuthCodeRequestGrantTypeEnum grantType = null;
        private Optional<String> redirectUri = Optional.empty();

        private Builder() {}

        public Builder from(ExchangeAuthCodeRequest other) {
            clientId(other.getClientId());
            clientSecret(other.getClientSecret());
            code(other.getCode());
            codeVerifier(other.getCodeVerifier());
            grantType(other.getGrantType());
            redirectUri(other.getRedirectUri());
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

        @JsonSetter("code")
        public Builder code(String code) {
            if (code == null) {
                throw new IllegalArgumentException("code cannot be null");
            }

            this.code = code;
            return this;
        }


        @JsonSetter("code_verifier")
        public Builder codeVerifier(String codeVerifier) {
            if (codeVerifier == null) {
                throw new IllegalArgumentException("codeVerifier cannot be null");
            }

            this.codeVerifier = codeVerifier;
            return this;
        }


        @JsonSetter("grant_type")
        public Builder grantType(ExchangeAuthCodeRequestGrantTypeEnum grantType) {
            if (grantType == null) {
                throw new IllegalArgumentException("grantType cannot be null");
            }

            this.grantType = grantType;
            return this;
        }


        @JsonSetter("redirect_uri")
        public Builder redirectUri(String redirectUri) {
            this.redirectUri = Optional.ofNullable(redirectUri);
            return this;
        }

        public Builder redirectUri(Optional<String> redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }


        public ExchangeAuthCodeRequest build() {
            if (code == null) {
                throw new IllegalStateException("code is required");
            }

            if (codeVerifier == null) {
                throw new IllegalStateException("codeVerifier is required");
            }

            if (grantType == null) {
                throw new IllegalStateException("grantType is required");
            }

            return new ExchangeAuthCodeRequest(
                       clientId,
                       clientSecret,
                       code,
                       codeVerifier,
                       grantType,
                       redirectUri
                   );
        }
    }

}




