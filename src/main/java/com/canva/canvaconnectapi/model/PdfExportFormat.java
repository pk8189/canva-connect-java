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
@JsonDeserialize(builder = PdfExportFormat.Builder.class)
public final class PdfExportFormat {
    private final Optional<ExportQualityEnum> exportQuality;
    /**
     * To specify which pages to export in a multi-page design, provide the page numbers as
     * an array. The first page in a design is page &#x60;1&#x60;.
     * If &#x60;pages&#x60; isn&#x27;t specified, all the pages are exported.
     */
    private final Optional<List<Integer>> pages;
    private final Optional<ExportPageSizeEnum> size;
    private final PdfExportFormatTypeEnum type;

    private PdfExportFormat(
        Optional<ExportQualityEnum> exportQuality,
        Optional<List<Integer>> pages,
        Optional<ExportPageSizeEnum> size,
        PdfExportFormatTypeEnum type
    ) {
        this.exportQuality = exportQuality;
        this.pages = pages;
        this.size = size;
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

    @JsonProperty("size")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExportPageSizeEnum getSize() {
        return size.orElse(null);
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public PdfExportFormatTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof PdfExportFormat && equalTo((PdfExportFormat) other);
    }

    private boolean equalTo(PdfExportFormat other) {
        return
            exportQuality.equals(other.exportQuality) &&

            pages.equals(other.pages) &&

            size.equals(other.size) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.exportQuality,
                   this.pages,
                   this.size,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "PdfExportFormat{" +
               "exportQuality=" + exportQuality +
               "pages=" + pages +
               "size=" + size +
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
        private Optional<ExportPageSizeEnum> size = Optional.empty();
        private PdfExportFormatTypeEnum type = null;

        private Builder() {}

        public Builder from(PdfExportFormat other) {
            exportQuality(other.getExportQuality());
            pages(other.getPages());
            size(other.getSize());
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

        @JsonSetter("size")
        public Builder size(ExportPageSizeEnum size) {
            this.size = Optional.ofNullable(size);
            return this;
        }

        public Builder size(Optional<ExportPageSizeEnum> size) {
            this.size = size;
            return this;
        }

        @JsonSetter("type")
        public Builder type(PdfExportFormatTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public PdfExportFormat build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new PdfExportFormat(
                       exportQuality,
                       pages,
                       size,
                       type
                   );
        }
    }

}




