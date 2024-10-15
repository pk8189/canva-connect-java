package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AssetUploadError.Builder.class)
public final class AssetUploadError {
    private final AssetUploadErrorCodeEnum code;
    /**
     * A human-readable description of what went wrong.
     */
    private final String message;

    private AssetUploadError(
        AssetUploadErrorCodeEnum code,
        String message
    ) {
        this.code = code;
        this.message = message;
    }

    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetUploadErrorCodeEnum getCode() {
        return code;
    }

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getMessage() {
        return message;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof AssetUploadError && equalTo((AssetUploadError) other);
    }

    private boolean equalTo(AssetUploadError other) {
        return
            code.equals(other.code) &&

            message.equals(other.message)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.code,
                   this.message
               );
    }

    @Override
    public String toString() {
        return "AssetUploadError{" +
               "code=" + code +
               "message=" + message +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private AssetUploadErrorCodeEnum code = null;
        private String message = null;

        private Builder() {}

        public Builder from(AssetUploadError other) {
            code(other.getCode());
            message(other.getMessage());
            return this;
        }

        @JsonSetter("code")
        public Builder code(AssetUploadErrorCodeEnum code) {
            if (code == null) {
                throw new IllegalArgumentException("code cannot be null");
            }

            this.code = code;
            return this;
        }


        @JsonSetter("message")
        public Builder message(String message) {
            if (message == null) {
                throw new IllegalArgumentException("message cannot be null");
            }

            this.message = message;
            return this;
        }



        public AssetUploadError build() {
            if (code == null) {
                throw new IllegalStateException("code is required");
            }

            if (message == null) {
                throw new IllegalStateException("message is required");
            }

            return new AssetUploadError(
                       code,
                       message
                   );
        }
    }

}




