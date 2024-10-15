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
@JsonDeserialize(builder = PngExportFormat.Builder.class)
public final class PngExportFormat {
    /**
     * When &#x60;true&#x60;, multi-page designs are merged into a single image.
     * When &#x60;false&#x60; (default), each page is exported as a separate image.
     */
    private final Optional<Boolean> asSingleImage;
    private final Optional<ExportQualityEnum> exportQuality;
    /**
     * Specify the height in pixels of the exported image. If only one of height or width is
     * specified, then the image will be scaled to match that dimension, respecting the design&#x27;s
     * aspect ratio. If no width or height is specified, the image will be exported using the
     * dimensions of the design.
     */
    private final Optional<Integer> height;
    /**
     * If set to &#x60;true&#x60; (Default), the PNG is exported without compression.
     * If set to &#x60;false&#x60;, the PNG is compressed using a lossy compression algorithm. Lossy PNG compression is only available to users on a Canva plan that has premium features, such as Canva Pro. If the user is on the Canva Free plan and this parameter is set to &#x60;false&#x60;, the export operation will fail.
     */
    private final Optional<Boolean> lossless;
    /**
     * To specify which pages to export in a multi-page design, provide the page numbers as
     * an array. The first page in a design is page &#x60;1&#x60;.
     * If &#x60;pages&#x60; isn&#x27;t specified, all the pages are exported.
     */
    private final Optional<List<Integer>> pages;
    private final PngExportFormatTypeEnum type;
    /**
     * Specify the width in pixels of the exported image. If only one of height or width is
     * specified, then the image will be scaled to match that dimension, respecting the design&#x27;s
     * aspect ratio. If no width or height is specified, the image will be exported using the
     * dimensions of the design.
     */
    private final Optional<Integer> width;

    private PngExportFormat(
        Optional<Boolean> asSingleImage,
        Optional<ExportQualityEnum> exportQuality,
        Optional<Integer> height,
        Optional<Boolean> lossless,
        Optional<List<Integer>> pages,
        PngExportFormatTypeEnum type,
        Optional<Integer> width
    ) {
        this.asSingleImage = asSingleImage;
        this.exportQuality = exportQuality;
        this.height = height;
        this.lossless = lossless;
        this.pages = pages;
        this.type = type;
        this.width = width;
    }

    @JsonProperty("as_single_image")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getAsSingleImage() {
        return asSingleImage.orElse(null);
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

    @JsonProperty("lossless")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Boolean getLossless() {
        return lossless.orElse(null);
    }

    @JsonProperty("pages")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<Integer> getPages() {
        return pages.orElse(null);
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public PngExportFormatTypeEnum getType() {
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

        return other instanceof PngExportFormat && equalTo((PngExportFormat) other);
    }

    private boolean equalTo(PngExportFormat other) {
        return
            asSingleImage.equals(other.asSingleImage) &&

            exportQuality.equals(other.exportQuality) &&

            height.equals(other.height) &&

            lossless.equals(other.lossless) &&

            pages.equals(other.pages) &&

            type.equals(other.type) &&

            width.equals(other.width)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.asSingleImage,
                   this.exportQuality,
                   this.height,
                   this.lossless,
                   this.pages,
                   this.type,
                   this.width
               );
    }

    @Override
    public String toString() {
        return "PngExportFormat{" +
               "asSingleImage=" + asSingleImage +
               "exportQuality=" + exportQuality +
               "height=" + height +
               "lossless=" + lossless +
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
        private Optional<Boolean> asSingleImage = Optional.empty();
        private Optional<ExportQualityEnum> exportQuality = Optional.empty();
        private Optional<Integer> height = Optional.empty();
        private Optional<Boolean> lossless = Optional.empty();
        private Optional<List<Integer>> pages = Optional.empty();
        private PngExportFormatTypeEnum type = null;
        private Optional<Integer> width = Optional.empty();

        private Builder() {}

        public Builder from(PngExportFormat other) {
            asSingleImage(other.getAsSingleImage());
            exportQuality(other.getExportQuality());
            height(other.getHeight());
            lossless(other.getLossless());
            pages(other.getPages());
            type(other.getType());
            width(other.getWidth());
            return this;
        }

        @JsonSetter("as_single_image")
        public Builder asSingleImage(Boolean asSingleImage) {
            this.asSingleImage = Optional.ofNullable(asSingleImage);
            return this;
        }

        public Builder asSingleImage(Optional<Boolean> asSingleImage) {
            this.asSingleImage = asSingleImage;
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

        @JsonSetter("lossless")
        public Builder lossless(Boolean lossless) {
            this.lossless = Optional.ofNullable(lossless);
            return this;
        }

        public Builder lossless(Optional<Boolean> lossless) {
            this.lossless = lossless;
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
        public Builder type(PngExportFormatTypeEnum type) {
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


        public PngExportFormat build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new PngExportFormat(
                       asSingleImage,
                       exportQuality,
                       height,
                       lossless,
                       pages,
                       type,
                       width
                   );
        }
    }

}




