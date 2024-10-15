package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ImportError.Builder.class)
public final class ImportError {
    private final ImportErrorCodeEnum code;
    /**
     * A human-readable description of what went wrong.
     */
    private final String message;

    private ImportError(
        ImportErrorCodeEnum code,
        String message
    ) {
        this.code = code;
        this.message = message;
    }

    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ImportErrorCodeEnum getCode() {
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

        return other instanceof ImportError && equalTo((ImportError) other);
    }

    private boolean equalTo(ImportError other) {
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
        return "ImportError{" +
               "code=" + code +
               "message=" + message +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ImportErrorCodeEnum code = null;
        private String message = null;

        private Builder() {}

        public Builder from(ImportError other) {
            code(other.getCode());
            message(other.getMessage());
            return this;
        }

        @JsonSetter("code")
        public Builder code(ImportErrorCodeEnum code) {
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



        public ImportError build() {
            if (code == null) {
                throw new IllegalStateException("code is required");
            }

            if (message == null) {
                throw new IllegalStateException("message is required");
            }

            return new ImportError(
                       code,
                       message
                   );
        }
    }

}




