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
@JsonDeserialize(builder = Mp4ExportFormat.Builder.class)
public final class Mp4ExportFormat {
    private final Optional<ExportQualityEnum> exportQuality;
    /**
     * To specify which pages to export in a multi-page design, provide the page numbers as
     * an array. The first page in a design is page &#x60;1&#x60;.
     * If &#x60;pages&#x60; isn&#x27;t specified, all the pages are exported.
     */
    private final Optional<List<Integer>> pages;
    private final Mp4ExportQualityEnum quality;
    private final Mp4ExportFormatTypeEnum type;

    private Mp4ExportFormat(
        Optional<ExportQualityEnum> exportQuality,
        Optional<List<Integer>> pages,
        Mp4ExportQualityEnum quality,
        Mp4ExportFormatTypeEnum type
    ) {
        this.exportQuality = exportQuality;
        this.pages = pages;
        this.quality = quality;
        this.type = type;
    }

    @JsonProperty("export_quality")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExportQualityEnum getExportQuality() {
        return exportQuality.orElse(null);
    }

    @JsonProperty("pages")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<Integer> getPages() {
        return pages.orElse(null);
    }

    @JsonProperty("quality")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Mp4ExportQualityEnum getQuality() {
        return quality;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Mp4ExportFormatTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof Mp4ExportFormat && equalTo((Mp4ExportFormat) other);
    }

    private boolean equalTo(Mp4ExportFormat other) {
        return
            exportQuality.equals(other.exportQuality) &&

            pages.equals(other.pages) &&

            quality.equals(other.quality) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.exportQuality,
                   this.pages,
                   this.quality,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "Mp4ExportFormat{" +
               "exportQuality=" + exportQuality +
               "pages=" + pages +
               "quality=" + quality +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<ExportQualityEnum> exportQuality = Optional.empty();
        private Optional<List<Integer>> pages = Optional.empty();
        private Mp4ExportQualityEnum quality = null;
        private Mp4ExportFormatTypeEnum type = null;

        private Builder() {}

        public Builder from(Mp4ExportFormat other) {
            exportQuality(other.getExportQuality());
            pages(other.getPages());
            quality(other.getQuality());
            type(other.getType());
            return this;
        }

        @JsonSetter("export_quality")
        public Builder exportQuality(ExportQualityEnum exportQuality) {
            this.exportQuality = Optional.ofNullable(exportQuality);
            return this;
        }

        public Builder exportQuality(Optional<ExportQualityEnum> exportQuality) {
            this.exportQuality = exportQuality;
            return this;
        }

        @JsonSetter("pages")
        public Builder pages(List<Integer> pages) {
            this.pages = Optional.ofNullable(pages);
            return this;
        }

        public Builder pages(Optional<List<Integer>> pages) {
            this.pages = pages;
            return this;
        }

        @JsonSetter("quality")
        public Builder quality(Mp4ExportQualityEnum quality) {
            if (quality == null) {
                throw new IllegalArgumentException("quality cannot be null");
            }

            this.quality = quality;
            return this;
        }


        @JsonSetter("type")
        public Builder type(Mp4ExportFormatTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public Mp4ExportFormat build() {
            if (quality == null) {
                throw new IllegalStateException("quality is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new Mp4ExportFormat(
                       exportQuality,
                       pages,
                       quality,
                       type
                   );
        }
    }

}




