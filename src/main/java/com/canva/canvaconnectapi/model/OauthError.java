package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = OauthError.Builder.class)
public final class OauthError {
    private final ErrorCodeEnum error;
    /**
     * A human-readable description of what went wrong.
     */
    private final String errorDescription;

    private OauthError(
        ErrorCodeEnum error,
        String errorDescription
    ) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ErrorCodeEnum getError() {
        return error;
    }

    @JsonProperty("error_description")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getErrorDescription() {
        return errorDescription;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof OauthError && equalTo((OauthError) other);
    }

    private boolean equalTo(OauthError other) {
        return
            error.equals(other.error) &&

            errorDescription.equals(other.errorDescription)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.error,
                   this.errorDescription
               );
    }

    @Override
    public String toString() {
        return "OauthError{" +
               "error=" + error +
               "errorDescription=" + errorDescription +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ErrorCodeEnum error = null;
        private String errorDescription = null;

        private Builder() {}

        public Builder from(OauthError other) {
            error(other.getError());
            errorDescription(other.getErrorDescription());
            return this;
        }

        @JsonSetter("error")
        public Builder error(ErrorCodeEnum error) {
            if (error == null) {
                throw new IllegalArgumentException("error cannot be null");
            }

            this.error = error;
            return this;
        }


        @JsonSetter("error_description")
        public Builder errorDescription(String errorDescription) {
            if (errorDescription == null) {
                throw new IllegalArgumentException("errorDescription cannot be null");
            }

            this.errorDescription = errorDescription;
            return this;
        }



        public OauthError build() {
            if (error == null) {
                throw new IllegalStateException("error is required");
            }

            if (errorDescription == null) {
                throw new IllegalStateException("errorDescription is required");
            }

            return new OauthError(
                       error,
                       errorDescription
                   );
        }
    }

}




