package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetDesignExportJobResponse.Builder.class)
public final class GetDesignExportJobResponse {
    private final ExportJob job;

    private GetDesignExportJobResponse(
        ExportJob job
    ) {
        this.job = job;
    }

    @JsonProperty("job")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExportJob getJob() {
        return job;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetDesignExportJobResponse && equalTo((GetDesignExportJobResponse) other);
    }

    private boolean equalTo(GetDesignExportJobResponse other) {
        return
            job.equals(other.job)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.job
               );
    }

    @Override
    public String toString() {
        return "GetDesignExportJobResponse{" +
               "job=" + job +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ExportJob job = null;

        private Builder() {}

        public Builder from(GetDesignExportJobResponse other) {
            job(other.getJob());
            return this;
        }

        @JsonSetter("job")
        public Builder job(ExportJob job) {
            if (job == null) {
                throw new IllegalArgumentException("job cannot be null");
            }

            this.job = job;
            return this;
        }



        public GetDesignExportJobResponse build() {
            if (job == null) {
                throw new IllegalStateException("job is required");
            }

            return new GetDesignExportJobResponse(
                       job
                   );
        }
    }

}




