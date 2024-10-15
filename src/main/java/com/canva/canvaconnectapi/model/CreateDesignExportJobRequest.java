package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateDesignExportJobRequest.Builder.class)
public final class CreateDesignExportJobRequest {
    /**
     * The design ID.
     */
    private final String designId;
    private final ExportFormat format;

    private CreateDesignExportJobRequest(
        String designId,
        ExportFormat format
    ) {
        this.designId = designId;
        this.format = format;
    }

    @JsonProperty("design_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDesignId() {
        return designId;
    }

    @JsonProperty("format")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExportFormat getFormat() {
        return format;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateDesignExportJobRequest &&
               equalTo((CreateDesignExportJobRequest) other);
    }

    private boolean equalTo(CreateDesignExportJobRequest other) {
        return
            designId.equals(other.designId) &&

            format.equals(other.format)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.designId,
                   this.format
               );
    }

    @Override
    public String toString() {
        return "CreateDesignExportJobRequest{" +
               "designId=" + designId +
               "format=" + format +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String designId = null;
        private ExportFormat format = null;

        private Builder() {}

        public Builder from(CreateDesignExportJobRequest other) {
            designId(other.getDesignId());
            format(other.getFormat());
            return this;
        }

        @JsonSetter("design_id")
        public Builder designId(String designId) {
            if (designId == null) {
                throw new IllegalArgumentException("designId cannot be null");
            }

            this.designId = designId;
            return this;
        }


        @JsonSetter("format")
        public Builder format(ExportFormat format) {
            if (format == null) {
                throw new IllegalArgumentException("format cannot be null");
            }

            this.format = format;
            return this;
        }



        public CreateDesignExportJobRequest build() {
            if (designId == null) {
                throw new IllegalStateException("designId is required");
            }

            if (format == null) {
                throw new IllegalStateException("format is required");
            }

            return new CreateDesignExportJobRequest(
                       designId,
                       format
                   );
        }
    }

}




