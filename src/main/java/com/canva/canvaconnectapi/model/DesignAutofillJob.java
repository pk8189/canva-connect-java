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
@JsonDeserialize(builder = DesignAutofillJob.Builder.class)
public final class DesignAutofillJob {
    private final Optional<AutofillError> error;
    /**
     * ID of the asynchronous job that is creating the design using the provided data.
     */
    private final String id;
    private final Optional<CreateDesignAutofillJobResult> result;
    private final DesignAutofillStatusEnum status;

    private DesignAutofillJob(
        Optional<AutofillError> error,
        String id,
        Optional<CreateDesignAutofillJobResult> result,
        DesignAutofillStatusEnum status
    ) {
        this.error = error;
        this.id = id;
        this.result = result;
        this.status = status;
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AutofillError getError() {
        return error.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }

    @JsonProperty("result")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public CreateDesignAutofillJobResult getResult() {
        return result.orElse(null);
    }

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignAutofillStatusEnum getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignAutofillJob && equalTo((DesignAutofillJob) other);
    }

    private boolean equalTo(DesignAutofillJob other) {
        return
            error.equals(other.error) &&

            id.equals(other.id) &&

            result.equals(other.result) &&

            status.equals(other.status)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.error,
                   this.id,
                   this.result,
                   this.status
               );
    }

    @Override
    public String toString() {
        return "DesignAutofillJob{" +
               "error=" + error +
               "id=" + id +
               "result=" + result +
               "status=" + status +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<AutofillError> error = Optional.empty();
        private String id = null;
        private Optional<CreateDesignAutofillJobResult> result = Optional.empty();
        private DesignAutofillStatusEnum status = null;

        private Builder() {}

        public Builder from(DesignAutofillJob other) {
            error(other.getError());
            id(other.getId());
            result(other.getResult());
            status(other.getStatus());
            return this;
        }

        @JsonSetter("error")
        public Builder error(AutofillError error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<AutofillError> error) {
            this.error = error;
            return this;
        }

        @JsonSetter("id")
        public Builder id(String id) {
            if (id == null) {
                throw new IllegalArgumentException("id cannot be null");
            }

            this.id = id;
            return this;
        }


        @JsonSetter("result")
        public Builder result(CreateDesignAutofillJobResult result) {
            this.result = Optional.ofNullable(result);
            return this;
        }

        public Builder result(Optional<CreateDesignAutofillJobResult> result) {
            this.result = result;
            return this;
        }

        @JsonSetter("status")
        public Builder status(DesignAutofillStatusEnum status) {
            if (status == null) {
                throw new IllegalArgumentException("status cannot be null");
            }

            this.status = status;
            return this;
        }



        public DesignAutofillJob build() {
            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (status == null) {
                throw new IllegalStateException("status is required");
            }

            return new DesignAutofillJob(
                       error,
                       id,
                       result,
                       status
                   );
        }
    }

}




