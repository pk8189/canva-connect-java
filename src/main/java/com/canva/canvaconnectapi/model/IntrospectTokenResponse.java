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
@JsonDeserialize(builder = IntrospectTokenResponse.Builder.class)
public final class IntrospectTokenResponse {
    /**
     * Whether the access token is active.
     *
     * If &#x60;true&#x60;, the access token is valid and active. If &#x60;false&#x60;, the access token is invalid.
     *
     */
    private final Boolean active;
    /**
     * The ID of the client that requested the token.
     */
    private final Optional<String> client;
    /**
     * The expiration time of the token, as a [Unix timestamp](https://en.wikipedia.org/wiki/Unix_time) in seconds.
     */
    private final Optional<Integer> exp;
    /**
     * When the token was issued, as a [Unix timestamp](https://en.wikipedia.org/wiki/Unix_time) in seconds.
     */
    private final Optional<Integer> iat;
    /**
     * A unique ID for the access token.
     */
    private final Optional<String> jti;
    /**
     * The &quot;not before&quot; time of the token, which specifies the time before which the access token most not be accepted, as a [Unix timestamp](https://en.wikipedia.org/wiki/Unix_time) in seconds.
     */
    private final Optional<Integer> nbf;
    /**
     * The [scopes](https://www.canva.dev/docs/connect/appendix/scopes/) that the token has been granted.
     */
    private final Optional<String> scope;
    /**
     * The subject of the claim. This is the ID of the Canva user that the access token acts on behalf of.
     *
     * This is an obfuscated value, so a single user has a unique ID for each integration. If the same user authorizes another integration, their ID in that other integration is different.
     *
     */
    private final Optional<String> sub;

    private IntrospectTokenResponse(
        Boolean active,
        Optional<String> client,
        Optional<Integer> exp,
        Optional<Integer> iat,
        Optional<String> jti,
        Optional<Integer> nbf,
        Optional<String> scope,
        Optional<String> sub
    ) {
        this.active = active;
        this.client = client;
        this.exp = exp;
        this.iat = iat;
        this.jti = jti;
        this.nbf = nbf;
        this.scope = scope;
        this.sub = sub;
    }

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("client")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getClient() {
        return client.orElse(null);
    }

    @JsonProperty("exp")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getExp() {
        return exp.orElse(null);
    }

    @JsonProperty("iat")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getIat() {
        return iat.orElse(null);
    }

    @JsonProperty("jti")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getJti() {
        return jti.orElse(null);
    }

    @JsonProperty("nbf")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getNbf() {
        return nbf.orElse(null);
    }

    @JsonProperty("scope")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getScope() {
        return scope.orElse(null);
    }

    @JsonProperty("sub")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getSub() {
        return sub.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof IntrospectTokenResponse && equalTo((IntrospectTokenResponse) other);
    }

    private boolean equalTo(IntrospectTokenResponse other) {
        return
            active.equals(other.active) &&

            client.equals(other.client) &&

            exp.equals(other.exp) &&

            iat.equals(other.iat) &&

            jti.equals(other.jti) &&

            nbf.equals(other.nbf) &&

            scope.equals(other.scope) &&

            sub.equals(other.sub)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.active,
                   this.client,
                   this.exp,
                   this.iat,
                   this.jti,
                   this.nbf,
                   this.scope,
                   this.sub
               );
    }

    @Override
    public String toString() {
        return "IntrospectTokenResponse{" +
               "active=" + active +
               "client=" + client +
               "exp=" + exp +
               "iat=" + iat +
               "jti=" + jti +
               "nbf=" + nbf +
               "scope=" + scope +
               "sub=" + sub +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Boolean active = null;
        private Optional<String> client = Optional.empty();
        private Optional<Integer> exp = Optional.empty();
        private Optional<Integer> iat = Optional.empty();
        private Optional<String> jti = Optional.empty();
        private Optional<Integer> nbf = Optional.empty();
        private Optional<String> scope = Optional.empty();
        private Optional<String> sub = Optional.empty();

        private Builder() {}

        public Builder from(IntrospectTokenResponse other) {
            active(other.getActive());
            client(other.getClient());
            exp(other.getExp());
            iat(other.getIat());
            jti(other.getJti());
            nbf(other.getNbf());
            scope(other.getScope());
            sub(other.getSub());
            return this;
        }

        @JsonSetter("active")
        public Builder active(Boolean active) {
            if (active == null) {
                throw new IllegalArgumentException("active cannot be null");
            }

            this.active = active;
            return this;
        }


        @JsonSetter("client")
        public Builder client(String client) {
            this.client = Optional.ofNullable(client);
            return this;
        }

        public Builder client(Optional<String> client) {
            this.client = client;
            return this;
        }

        @JsonSetter("exp")
        public Builder exp(Integer exp) {
            this.exp = Optional.ofNullable(exp);
            return this;
        }

        public Builder exp(Optional<Integer> exp) {
            this.exp = exp;
            return this;
        }

        @JsonSetter("iat")
        public Builder iat(Integer iat) {
            this.iat = Optional.ofNullable(iat);
            return this;
        }

        public Builder iat(Optional<Integer> iat) {
            this.iat = iat;
            return this;
        }

        @JsonSetter("jti")
        public Builder jti(String jti) {
            this.jti = Optional.ofNullable(jti);
            return this;
        }

        public Builder jti(Optional<String> jti) {
            this.jti = jti;
            return this;
        }

        @JsonSetter("nbf")
        public Builder nbf(Integer nbf) {
            this.nbf = Optional.ofNullable(nbf);
            return this;
        }

        public Builder nbf(Optional<Integer> nbf) {
            this.nbf = nbf;
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

        @JsonSetter("sub")
        public Builder sub(String sub) {
            this.sub = Optional.ofNullable(sub);
            return this;
        }

        public Builder sub(Optional<String> sub) {
            this.sub = sub;
            return this;
        }


        public IntrospectTokenResponse build() {
            if (active == null) {
                throw new IllegalStateException("active is required");
            }

            return new IntrospectTokenResponse(
                       active,
                       client,
                       exp,
                       iat,
                       jti,
                       nbf,
                       scope,
                       sub
                   );
        }
    }

}




