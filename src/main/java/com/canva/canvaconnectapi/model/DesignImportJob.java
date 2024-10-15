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
@JsonDeserialize(builder = DesignImportJob.Builder.class)
public final class DesignImportJob {
    private final Optional<DesignImportError> error;
    /**
     * The ID of the design import job.
     */
    private final String id;
    private final Optional<DesignImportJobResult> result;
    private final DesignImportStatusEnum status;

    private DesignImportJob(
        Optional<DesignImportError> error,
        String id,
        Optional<DesignImportJobResult> result,
        DesignImportStatusEnum status
    ) {
        this.error = error;
        this.id = id;
        this.result = result;
        this.status = status;
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignImportError getError() {
        return error.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }

    @JsonProperty("result")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignImportJobResult getResult() {
        return result.orElse(null);
    }

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignImportStatusEnum getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignImportJob && equalTo((DesignImportJob) other);
    }

    private boolean equalTo(DesignImportJob other) {
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
        return "DesignImportJob{" +
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
        private Optional<DesignImportError> error = Optional.empty();
        private String id = null;
        private Optional<DesignImportJobResult> result = Optional.empty();
        private DesignImportStatusEnum status = null;

        private Builder() {}

        public Builder from(DesignImportJob other) {
            error(other.getError());
            id(other.getId());
            result(other.getResult());
            status(other.getStatus());
            return this;
        }

        @JsonSetter("error")
        public Builder error(DesignImportError error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<DesignImportError> error) {
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
        public Builder result(DesignImportJobResult result) {
            this.result = Optional.ofNullable(result);
            return this;
        }

        public Builder result(Optional<DesignImportJobResult> result) {
            this.result = result;
            return this;
        }

        @JsonSetter("status")
        public Builder status(DesignImportStatusEnum status) {
            if (status == null) {
                throw new IllegalArgumentException("status cannot be null");
            }

            this.status = status;
            return this;
        }



        public DesignImportJob build() {
            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (status == null) {
                throw new IllegalStateException("status is required");
            }

            return new DesignImportJob(
                       error,
                       id,
                       result,
                       status
                   );
        }
    }

}




