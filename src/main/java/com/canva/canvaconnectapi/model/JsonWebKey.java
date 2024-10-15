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
@JsonDeserialize(builder = JsonWebKey.Builder.class)
public final class JsonWebKey {
    /**
     * The &quot;alg&quot; (algorithm) parameter identifies the algorithm intended for
     * use with the key.
     * See https://www.rfc-editor.org/rfc/rfc7517#section-4
     */
    private final Optional<String> alg;
    /**
     * The &quot;e&quot; (exponent) parameter contains the exponent value for the RSA
     *    public key.  It is represented as a Base64urlUInt-encoded value.
     * See https://www.rfc-editor.org/rfc/rfc7518.html#section-6.3
     */
    private final String e;
    /**
     * The &quot;kid&quot; (key ID) parameter is used to match a specific key.  This
     * is used, for instance, to choose among a set of keys within a JWK Set
     * during key rollover. When &quot;kid&quot; values are used within a JWK Set,
     * different keys within the JWK Set SHOULD use distinct &quot;kid&quot; values.
     * The &quot;kid&quot; value is a case-sensitive string.
     * See https://www.rfc-editor.org/rfc/rfc7517#section-4
     */
    private final String kid;
    /**
     * The &quot;kty&quot; (key type) parameter identifies the cryptographic algorithm
     * family used with the key, such as &quot;RSA&quot; or &quot;EC&quot;. The &quot;kty&quot; value is a
     * case-sensitive string. At the moment, only &quot;RSA&quot; is supported.
     * See https://www.rfc-editor.org/rfc/rfc7517#section-4
     */
    private final String kty;
    /**
     * The &quot;n&quot; (modulus) parameter contains the modulus value for the RSA
     *    public key.  It is represented as a Base64urlUInt-encoded value.
     * See https://www.rfc-editor.org/rfc/rfc7518.html#section-6.3
     */
    private final String n;
    /**
     * The &quot;use&quot; (public key use) parameter identifies the intended use of
     * the public key. The &quot;use&quot; parameter is employed to indicate whether
     * a public key is used for encrypting data or verifying the signature
     * on data. Values are commonly &quot;sig&quot; (signature) or &quot;enc&quot; (encryption).
     * See https://www.rfc-editor.org/rfc/rfc7517#section-4
     */
    private final Optional<String> use;

    private JsonWebKey(
        Optional<String> alg,
        String e,
        String kid,
        String kty,
        String n,
        Optional<String> use
    ) {
        this.alg = alg;
        this.e = e;
        this.kid = kid;
        this.kty = kty;
        this.n = n;
        this.use = use;
    }

    @JsonProperty("alg")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAlg() {
        return alg.orElse(null);
    }

    @JsonProperty("e")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getE() {
        return e;
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

    @JsonProperty("n")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getN() {
        return n;
    }

    @JsonProperty("use")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUse() {
        return use.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof JsonWebKey && equalTo((JsonWebKey) other);
    }

    private boolean equalTo(JsonWebKey other) {
        return
            alg.equals(other.alg) &&

            e.equals(other.e) &&

            kid.equals(other.kid) &&

            kty.equals(other.kty) &&

            n.equals(other.n) &&

            use.equals(other.use)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.alg,
                   this.e,
                   this.kid,
                   this.kty,
                   this.n,
                   this.use
               );
    }

    @Override
    public String toString() {
        return "JsonWebKey{" +
               "alg=" + alg +
               "e=" + e +
               "kid=" + kid +
               "kty=" + kty +
               "n=" + n +
               "use=" + use +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> alg = Optional.empty();
        private String e = null;
        private String kid = null;
        private String kty = null;
        private String n = null;
        private Optional<String> use = Optional.empty();

        private Builder() {}

        public Builder from(JsonWebKey other) {
            alg(other.getAlg());
            e(other.getE());
            kid(other.getKid());
            kty(other.getKty());
            n(other.getN());
            use(other.getUse());
            return this;
        }

        @JsonSetter("alg")
        public Builder alg(String alg) {
            this.alg = Optional.ofNullable(alg);
            return this;
        }

        public Builder alg(Optional<String> alg) {
            this.alg = alg;
            return this;
        }

        @JsonSetter("e")
        public Builder e(String e) {
            if (e == null) {
                throw new IllegalArgumentException("e cannot be null");
            }

            this.e = e;
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


        @JsonSetter("n")
        public Builder n(String n) {
            if (n == null) {
                throw new IllegalArgumentException("n cannot be null");
            }

            this.n = n;
            return this;
        }


        @JsonSetter("use")
        public Builder use(String use) {
            this.use = Optional.ofNullable(use);
            return this;
        }

        public Builder use(Optional<String> use) {
            this.use = use;
            return this;
        }


        public JsonWebKey build() {
            if (e == null) {
                throw new IllegalStateException("e is required");
            }

            if (kid == null) {
                throw new IllegalStateException("kid is required");
            }

            if (kty == null) {
                throw new IllegalStateException("kty is required");
            }

            if (n == null) {
                throw new IllegalStateException("n is required");
            }

            return new JsonWebKey(
                       alg,
                       e,
                       kid,
                       kty,
                       n,
                       use
                   );
        }
    }

}




