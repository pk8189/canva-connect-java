package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateAssetUploadJobResponse.Builder.class)
public final class CreateAssetUploadJobResponse {
    private final AssetUploadJob job;

    private CreateAssetUploadJobResponse(
        AssetUploadJob job
    ) {
        this.job = job;
    }

    @JsonProperty("job")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetUploadJob getJob() {
        return job;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateAssetUploadJobResponse &&
               equalTo((CreateAssetUploadJobResponse) other);
    }

    private boolean equalTo(CreateAssetUploadJobResponse other) {
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
        return "CreateAssetUploadJobResponse{" +
               "job=" + job +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private AssetUploadJob job = null;

        private Builder() {}

        public Builder from(CreateAssetUploadJobResponse other) {
            job(other.getJob());
            return this;
        }

        @JsonSetter("job")
        public Builder job(AssetUploadJob job) {
            if (job == null) {
                throw new IllegalArgumentException("job cannot be null");
            }

            this.job = job;
            return this;
        }



        public CreateAssetUploadJobResponse build() {
            if (job == null) {
                throw new IllegalStateException("job is required");
            }

            return new CreateAssetUploadJobResponse(
                       job
                   );
        }
    }

}




