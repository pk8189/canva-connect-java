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
@JsonDeserialize(builder = DesignImportMetadata.Builder.class)
public final class DesignImportMetadata {
    /**
     * The MIME type of the file being imported. If not provided, Canva attempts to automatically detect the type of the file.
     */
    private final Optional<String> mimeType;
    /**
     * The design&#x27;s title, encoded in Base64.
     *
     * The maximum length of a design title in Canva (unencoded) is 50 characters.
     *
     * Base64 encoding allows titles containing emojis and other special
     * characters to be sent using HTTP headers.
     * For example, &quot;My Awesome Design 😍&quot; Base64 encoded
     * is &#x60;TXkgQXdlc29tZSBEZXNpZ24g8J+YjQ&#x3D;&#x3D;&#x60;.
     */
    private final String titleBase64;

    private DesignImportMetadata(
        Optional<String> mimeType,
        String titleBase64
    ) {
        this.mimeType = mimeType;
        this.titleBase64 = titleBase64;
    }

    @JsonProperty("mime_type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getMimeType() {
        return mimeType.orElse(null);
    }

    @JsonProperty("title_base64")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTitleBase64() {
        return titleBase64;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignImportMetadata && equalTo((DesignImportMetadata) other);
    }

    private boolean equalTo(DesignImportMetadata other) {
        return
            mimeType.equals(other.mimeType) &&

            titleBase64.equals(other.titleBase64)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.mimeType,
                   this.titleBase64
               );
    }

    @Override
    public String toString() {
        return "DesignImportMetadata{" +
               "mimeType=" + mimeType +
               "titleBase64=" + titleBase64 +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> mimeType = Optional.empty();
        private String titleBase64 = null;

        private Builder() {}

        public Builder from(DesignImportMetadata other) {
            mimeType(other.getMimeType());
            titleBase64(other.getTitleBase64());
            return this;
        }

        @JsonSetter("mime_type")
        public Builder mimeType(String mimeType) {
            this.mimeType = Optional.ofNullable(mimeType);
            return this;
        }

        public Builder mimeType(Optional<String> mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        @JsonSetter("title_base64")
        public Builder titleBase64(String titleBase64) {
            if (titleBase64 == null) {
                throw new IllegalArgumentException("titleBase64 cannot be null");
            }

            this.titleBase64 = titleBase64;
            return this;
        }



        public DesignImportMetadata build() {
            if (titleBase64 == null) {
                throw new IllegalStateException("titleBase64 is required");
            }

            return new DesignImportMetadata(
                       mimeType,
                       titleBase64
                   );
        }
    }

}




