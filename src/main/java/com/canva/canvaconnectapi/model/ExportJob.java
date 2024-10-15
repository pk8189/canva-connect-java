package com.canva.canvaconnectapi.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ExportJob.Builder.class)
public final class ExportJob {
    private final Optional<ExportError> error;
    /**
     * The export job ID.
     */
    private final String id;
    private final DesignExportStatusEnum status;
    /**
     * When the export job is completed, also returns a list of urls for the exported
     * resources. The list is sorted by page order.
     */
    private final Optional<List<String>> urls;

    private ExportJob(
        Optional<ExportError> error,
        String id,
        DesignExportStatusEnum status,
        Optional<List<String>> urls
    ) {
        this.error = error;
        this.id = id;
        this.status = status;
        this.urls = urls;
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExportError getError() {
        return error.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignExportStatusEnum getStatus() {
        return status;
    }

    @JsonProperty("urls")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<String> getUrls() {
        return urls.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ExportJob && equalTo((ExportJob) other);
    }

    private boolean equalTo(ExportJob other) {
        return
            error.equals(other.error) &&

            id.equals(other.id) &&

            status.equals(other.status) &&

            urls.equals(other.urls)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.error,
                   this.id,
                   this.status,
                   this.urls
               );
    }

    @Override
    public String toString() {
        return "ExportJob{" +
               "error=" + error +
               "id=" + id +
               "status=" + status +
               "urls=" + urls +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<ExportError> error = Optional.empty();
        private String id = null;
        private DesignExportStatusEnum status = null;
        private Optional<List<String>> urls = Optional.empty();

        private Builder() {}

        public Builder from(ExportJob other) {
            error(other.getError());
            id(other.getId());
            status(other.getStatus());
            urls(other.getUrls());
            return this;
        }

        @JsonSetter("error")
        public Builder error(ExportError error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<ExportError> error) {
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


        @JsonSetter("status")
        public Builder status(DesignExportStatusEnum status) {
            if (status == null) {
                throw new IllegalArgumentException("status cannot be null");
            }

            this.status = status;
            return this;
        }


        @JsonSetter("urls")
        public Builder urls(List<String> urls) {
            this.urls = Optional.ofNullable(urls);
            return this;
        }

        public Builder urls(Optional<List<String>> urls) {
            this.urls = urls;
            return this;
        }


        public ExportJob build() {
            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (status == null) {
                throw new IllegalStateException("status is required");
            }

            return new ExportJob(
                       error,
                       id,
                       status,
                       urls
                   );
        }
    }

}




