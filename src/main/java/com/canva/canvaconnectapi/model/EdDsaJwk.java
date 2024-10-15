package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = EdDsaJwk.Builder.class)
public final class EdDsaJwk {
    /**
     * The &#x60;crv&#x60; (curve) property identifies the curve used for elliptical curve
     * encryptions. Only &quot;Ed25519&quot; is supported. For more information on the &#x60;crv&#x60;
     * property, see [RFC-8037 — Key Type
     * &quot;OKP&quot;](https://www.rfc-editor.org/rfc/rfc8037.html#section-2).
     */
    private final String crv;
    /**
     * The &#x60;kid&#x60; (key ID) is a unique identifier for a public key. When the keys used
     * to sign webhooks are rotated, you can use this ID to select the correct key
     * within a JWK Set during the key rollover. The &#x60;kid&#x60; value is case-sensitive.
     */
    private final String kid;
    /**
     * The &#x60;kty&#x60; (key type) identifies the cryptographic algorithm family used with
     * the key, such as &quot;RSA&quot; or &quot;EC&quot;. Only Octet Key Pairs
     * (&#x60;OKPs&#x60;) are supported.
     * The &#x60;kty&#x60; value is case-sensitive. For more information on the &#x60;kty&#x60; property
     * and OKPs, see [RFC-8037 — &quot;kty&quot; (Key Type)
     * Parameter](https://www.rfc-editor.org/rfc/rfc8037.html#section-2).
     */
    private final String kty;
    /**
     * The &#x60;x&#x60; property is the public key of an elliptical curve encryption. The key
     * is Base64urlUInt-encoded. For more information on the &#x60;x&#x60; property, see
     * [RFC-8037 — &quot;x&quot; (X Coordinate)
     * Parameter](https://www.rfc-editor.org/rfc/rfc8037#section-2).
     */
    private final String x;

    private EdDsaJwk(
        String crv,
        String kid,
        String kty,
        String x
    ) {
        this.crv = crv;
        this.kid = kid;
        this.kty = kty;
        this.x = x;
    }

    @JsonProperty("crv")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getCrv() {
        return crv;
    }

    @JsonProperty("kid")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getKid() {
        return kid;
    }

    @JsonProperty("kty")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getKty() {
        return kty;
    }

    @JsonProperty("x")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getX() {
        return x;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof EdDsaJwk && equalTo((EdDsaJwk) other);
    }

    private boolean equalTo(EdDsaJwk other) {
        return
            crv.equals(other.crv) &&

            kid.equals(other.kid) &&

            kty.equals(other.kty) &&

            x.equals(other.x)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.crv,
                   this.kid,
                   this.kty,
                   this.x
               );
    }

    @Override
    public String toString() {
        return "EdDsaJwk{" +
               "crv=" + crv +
               "kid=" + kid +
               "kty=" + kty +
               "x=" + x +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String crv = null;
        private String kid = null;
        private String kty = null;
        private String x = null;

        private Builder() {}

        public Builder from(EdDsaJwk other) {
            crv(other.getCrv());
            kid(other.getKid());
            kty(other.getKty());
            x(other.getX());
            return this;
        }

        @JsonSetter("crv")
        public Builder crv(String crv) {
            if (crv == null) {
                throw new IllegalArgumentException("crv cannot be null");
            }

            this.crv = crv;
            return this;
        }


        @JsonSetter("kid")
        public Builder kid(String kid) {
            if (kid == null) {
                throw new IllegalArgumentException("kid cannot be null");
            }

            this.kid = kid;
            return this;
        }


        @JsonSetter("kty")
        public Builder kty(String kty) {
            if (kty == null) {
                throw new IllegalArgumentException("kty cannot be null");
            }

            this.kty = kty;
            return this;
        }


        @JsonSetter("x")
        public Builder x(String x) {
            if (x == null) {
                throw new IllegalArgumentException("x cannot be null");
            }

            this.x = x;
            return this;
        }



        public EdDsaJwk build() {
            if (crv == null) {
                throw new IllegalStateException("crv is required");
            }

            if (kid == null) {
                throw new IllegalStateException("kid is required");
            }

            if (kty == null) {
                throw new IllegalStateException("kty is required");
            }

            if (x == null) {
                throw new IllegalStateException("x is required");
            }

            return new EdDsaJwk(
                       crv,
                       kid,
                       kty,
                       x
                   );
        }
    }

}




