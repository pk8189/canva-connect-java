package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetDesignAutofillJobResponse.Builder.class)
public final class GetDesignAutofillJobResponse {
    private final DesignAutofillJob job;

    private GetDesignAutofillJobResponse(
        DesignAutofillJob job
    ) {
        this.job = job;
    }

    @JsonProperty("job")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignAutofillJob getJob() {
        return job;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetDesignAutofillJobResponse &&
               equalTo((GetDesignAutofillJobResponse) other);
    }

    private boolean equalTo(GetDesignAutofillJobResponse other) {
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
        return "GetDesignAutofillJobResponse{" +
               "job=" + job +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DesignAutofillJob job = null;

        private Builder() {}

        public Builder from(GetDesignAutofillJobResponse other) {
            job(other.getJob());
            return this;
        }

        @JsonSetter("job")
        public Builder job(DesignAutofillJob job) {
            if (job == null) {
                throw new IllegalArgumentException("job cannot be null");
            }

            this.job = job;
            return this;
        }



        public GetDesignAutofillJobResponse build() {
            if (job == null) {
                throw new IllegalStateException("job is required");
            }

            return new GetDesignAutofillJobResponse(
                       job
                   );
        }
    }

}




