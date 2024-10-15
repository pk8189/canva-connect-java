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
@JsonDeserialize(builder = GifExportFormat.Builder.class)
public final class GifExportFormat {
    private final Optional<ExportQualityEnum> exportQuality;
    /**
     * Specify the height in pixels of the exported image. If only one of height or width is
     * specified, then the image will be scaled to match that dimension, respecting the design&#x27;s
     * aspect ratio. If no width or height is specified, the image will be exported using the
     * dimensions of the design.
     */
    private final Optional<Integer> height;
    /**
     * To specify which pages to export in a multi-page design, provide the page numbers as
     * an array. The first page in a design is page &#x60;1&#x60;.
     * If &#x60;pages&#x60; isn&#x27;t specified, all the pages are exported.
     */
    private final Optional<List<Integer>> pages;
    private final GifExportFormatTypeEnum type;
    /**
     * Specify the width in pixels of the exported image. If only one of height or width is
     * specified, then the image will be scaled to match that dimension, respecting the design&#x27;s
     * aspect ratio. If no width or height is specified, the image will be exported using the
     * dimensions of the design.
     */
    private final Optional<Integer> width;

    private GifExportFormat(
        Optional<ExportQualityEnum> exportQuality,
        Optional<Integer> height,
        Optional<List<Integer>> pages,
        GifExportFormatTypeEnum type,
        Optional<Integer> width
    ) {
        this.exportQuality = exportQuality;
        this.height = height;
        this.pages = pages;
        this.type = type;
        this.width = width;
    }

    @JsonProperty("export_quality")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ExportQualityEnum getExportQuality() {
        return exportQuality.orElse(null);
    }

    @JsonProperty("height")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getHeight() {
        return height.orElse(null);
    }

    @JsonProperty("pages")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<Integer> getPages() {
        return pages.orElse(null);
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public GifExportFormatTypeEnum getType() {
        return type;
    }

    @JsonProperty("width")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getWidth() {
        return width.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GifExportFormat && equalTo((GifExportFormat) other);
    }

    private boolean equalTo(GifExportFormat other) {
        return
            exportQuality.equals(other.exportQuality) &&

            height.equals(other.height) &&

            pages.equals(other.pages) &&

            type.equals(other.type) &&

            width.equals(other.width)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.exportQuality,
                   this.height,
                   this.pages,
                   this.type,
                   this.width
               );
    }

    @Override
    public String toString() {
        return "GifExportFormat{" +
               "exportQuality=" + exportQuality +
               "height=" + height +
               "pages=" + pages +
               "type=" + type +
               "width=" + width +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<ExportQualityEnum> exportQuality = Optional.empty();
        private Optional<Integer> height = Optional.empty();
        private Optional<List<Integer>> pages = Optional.empty();
        private GifExportFormatTypeEnum type = null;
        private Optional<Integer> width = Optional.empty();

        private Builder() {}

        public Builder from(GifExportFormat other) {
            exportQuality(other.getExportQuality());
            height(other.getHeight());
            pages(other.getPages());
            type(other.getType());
            width(other.getWidth());
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

        @JsonSetter("height")
        public Builder height(Integer height) {
            this.height = Optional.ofNullable(height);
            return this;
        }

        public Builder height(Optional<Integer> height) {
            this.height = height;
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

        @JsonSetter("type")
        public Builder type(GifExportFormatTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("width")
        public Builder width(Integer width) {
            this.width = Optional.ofNullable(width);
            return this;
        }

        public Builder width(Optional<Integer> width) {
            this.width = width;
            return this;
        }


        public GifExportFormat build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new GifExportFormat(
                       exportQuality,
                       height,
                       pages,
                       type,
                       width
                   );
        }
    }

}




