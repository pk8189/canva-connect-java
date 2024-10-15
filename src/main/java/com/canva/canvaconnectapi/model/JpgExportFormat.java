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
@JsonDeserialize(builder = JpgExportFormat.Builder.class)
public final class JpgExportFormat {
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
    /**
     * For the &#x60;jpg&#x60; type, the &#x60;quality&#x60; of the exported JPEG determines how compressed the exported file should be. A _low_ &#x60;quality&#x60; value (minimum &#x60;1&#x60;) will create a file with a smaller file size, but the resulting file will have pixelated artifacts when compared to a file created with a _high_ &#x60;quality&#x60; value (maximum &#x60;100&#x60;).
     */
    private final Integer quality;
    private final JpgExportFormatTypeEnum type;
    /**
     * Specify the width in pixels of the exported image. If only one of height or width is
     * specified, then the image will be scaled to match that dimension, respecting the design&#x27;s
     * aspect ratio. If no width or height is specified, the image will be exported using the
     * dimensions of the design.
     */
    private final Optional<Integer> width;

    private JpgExportFormat(
        Optional<ExportQualityEnum> exportQuality,
        Optional<Integer> height,
        Optional<List<Integer>> pages,
        Integer quality,
        JpgExportFormatTypeEnum type,
        Optional<Integer> width
    ) {
        this.exportQuality = exportQuality;
        this.height = height;
        this.pages = pages;
        this.quality = quality;
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

    @JsonProperty("quality")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getQuality() {
        return quality;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public JpgExportFormatTypeEnum getType() {
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

        return other instanceof JpgExportFormat && equalTo((JpgExportFormat) other);
    }

    private boolean equalTo(JpgExportFormat other) {
        return
            exportQuality.equals(other.exportQuality) &&

            height.equals(other.height) &&

            pages.equals(other.pages) &&

            quality.equals(other.quality) &&

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
                   this.quality,
                   this.type,
                   this.width
               );
    }

    @Override
    public String toString() {
        return "JpgExportFormat{" +
               "exportQuality=" + exportQuality +
               "height=" + height +
               "pages=" + pages +
               "quality=" + quality +
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
        private Integer quality = null;
        private JpgExportFormatTypeEnum type = null;
        private Optional<Integer> width = Optional.empty();

        private Builder() {}

        public Builder from(JpgExportFormat other) {
            exportQuality(other.getExportQuality());
            height(other.getHeight());
            pages(other.getPages());
            quality(other.getQuality());
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

        @JsonSetter("quality")
        public Builder quality(Integer quality) {
            if (quality == null) {
                throw new IllegalArgumentException("quality cannot be null");
            }

            this.quality = quality;
            return this;
        }


        @JsonSetter("type")
        public Builder type(JpgExportFormatTypeEnum type) {
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


        public JpgExportFormat build() {
            if (quality == null) {
                throw new IllegalStateException("quality is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new JpgExportFormat(
                       exportQuality,
                       height,
                       pages,
                       quality,
                       type,
                       width
                   );
        }
    }

}




