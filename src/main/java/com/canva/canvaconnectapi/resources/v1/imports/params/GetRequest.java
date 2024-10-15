package com.canva.canvaconnectapi.resources.v1.imports.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetRequest.Builder.class)
public final class GetRequest {
    private final String jobId;

    private GetRequest(
        String jobId
    ) {
        this.jobId = jobId;
    }

    @JsonProperty("jobId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getJobId() {
        return jobId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            jobId.equals(other.jobId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.jobId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "jobId=" + jobId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String jobId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            jobId(other.getJobId());
            return this;
        }

        @JsonSetter("jobId")
        public Builder jobId(String jobId) {
            if (jobId == null) {
                throw new IllegalArgumentException("jobId cannot be null");
            }

            this.jobId = jobId;
            return this;
        }



        public GetRequest build() {
            if (jobId == null) {
                throw new IllegalStateException("jobId is required");
            }

            return new GetRequest(
                       jobId
                   );
        }
    }

}




