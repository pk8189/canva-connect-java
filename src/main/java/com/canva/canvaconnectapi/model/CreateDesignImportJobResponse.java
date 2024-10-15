package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateDesignImportJobResponse.Builder.class)
public final class CreateDesignImportJobResponse {
    private final DesignImportJob job;

    private CreateDesignImportJobResponse(
        DesignImportJob job
    ) {
        this.job = job;
    }

    @JsonProperty("job")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignImportJob getJob() {
        return job;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateDesignImportJobResponse &&
               equalTo((CreateDesignImportJobResponse) other);
    }

    private boolean equalTo(CreateDesignImportJobResponse other) {
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
        return "CreateDesignImportJobResponse{" +
               "job=" + job +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DesignImportJob job = null;

        private Builder() {}

        public Builder from(CreateDesignImportJobResponse other) {
            job(other.getJob());
            return this;
        }

        @JsonSetter("job")
        public Builder job(DesignImportJob job) {
            if (job == null) {
                throw new IllegalArgumentException("job cannot be null");
            }

            this.job = job;
            return this;
        }



        public CreateDesignImportJobResponse build() {
            if (job == null) {
                throw new IllegalStateException("job is required");
            }

            return new CreateDesignImportJobResponse(
                       job
                   );
        }
    }

}




