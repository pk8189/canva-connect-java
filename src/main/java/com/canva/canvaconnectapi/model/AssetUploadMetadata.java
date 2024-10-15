package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AssetUploadMetadata.Builder.class)
public final class AssetUploadMetadata {
    /**
     * The asset&#x27;s name, encoded in Base64.
     *
     * The maximum length of an asset name in Canva (unencoded) is 50 characters.
     *
     * Base64 encoding allows names containing emojis and other special
     * characters to be sent using HTTP headers.
     * For example, &quot;My Awesome Upload 🚀&quot; Base64 encoded
     * is &#x60;TXkgQXdlc29tZSBVcGxvYWQg8J+agA&#x3D;&#x3D;&#x60;.
     */
    private final String nameBase64;

    private AssetUploadMetadata(
        String nameBase64
    ) {
        this.nameBase64 = nameBase64;
    }

    @JsonProperty("name_base64")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getNameBase64() {
        return nameBase64;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof AssetUploadMetadata && equalTo((AssetUploadMetadata) other);
    }

    private boolean equalTo(AssetUploadMetadata other) {
        return
            nameBase64.equals(other.nameBase64)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.nameBase64
               );
    }

    @Override
    public String toString() {
        return "AssetUploadMetadata{" +
               "nameBase64=" + nameBase64 +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String nameBase64 = null;

        private Builder() {}

        public Builder from(AssetUploadMetadata other) {
            nameBase64(other.getNameBase64());
            return this;
        }

        @JsonSetter("name_base64")
        public Builder nameBase64(String nameBase64) {
            if (nameBase64 == null) {
                throw new IllegalArgumentException("nameBase64 cannot be null");
            }

            this.nameBase64 = nameBase64;
            return this;
        }



        public AssetUploadMetadata build() {
            if (nameBase64 == null) {
                throw new IllegalStateException("nameBase64 is required");
            }

            return new AssetUploadMetadata(
                       nameBase64
                   );
        }
    }

}




