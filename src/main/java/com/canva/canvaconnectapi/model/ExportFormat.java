package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = ExportFormat.Deserializer.class)
public final class ExportFormat {
    private final Object value;

    private ExportFormat(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isPdfExportFormatVariant() {
        return value instanceof PdfExportFormat;
    }

    public PdfExportFormat asPdfExportFormatVariant() {
        return isPdfExportFormatVariant() ? (PdfExportFormat) value : null;
    }

    public boolean isJpgExportFormatVariant() {
        return value instanceof JpgExportFormat;
    }

    public JpgExportFormat asJpgExportFormatVariant() {
        return isJpgExportFormatVariant() ? (JpgExportFormat) value : null;
    }

    public boolean isPngExportFormatVariant() {
        return value instanceof PngExportFormat;
    }

    public PngExportFormat asPngExportFormatVariant() {
        return isPngExportFormatVariant() ? (PngExportFormat) value : null;
    }

    public boolean isPptxExportFormatVariant() {
        return value instanceof PptxExportFormat;
    }

    public PptxExportFormat asPptxExportFormatVariant() {
        return isPptxExportFormatVariant() ? (PptxExportFormat) value : null;
    }

    public boolean isGifExportFormatVariant() {
        return value instanceof GifExportFormat;
    }

    public GifExportFormat asGifExportFormatVariant() {
        return isGifExportFormatVariant() ? (GifExportFormat) value : null;
    }

    public boolean isMp4ExportFormatVariant() {
        return value instanceof Mp4ExportFormat;
    }

    public Mp4ExportFormat asMp4ExportFormatVariant() {
        return isMp4ExportFormatVariant() ? (Mp4ExportFormat) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        ExportFormat that = (ExportFormat) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ExportFormat of(Object value) {
        if (value instanceof PdfExportFormat || value instanceof JpgExportFormat ||
                value instanceof PngExportFormat || value instanceof PptxExportFormat ||
                value instanceof GifExportFormat || value instanceof Mp4ExportFormat) {
            return new ExportFormat(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<ExportFormat> {
        @Override
        public ExportFormat deserialize(com.fasterxml.jackson.core.JsonParser p,
                                        com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return ExportFormat.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExportFormat.of(ObjectMappers.JSON_MAPPER.convertValue(value, PdfExportFormat.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExportFormat.of(ObjectMappers.JSON_MAPPER.convertValue(value, JpgExportFormat.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExportFormat.of(ObjectMappers.JSON_MAPPER.convertValue(value, PngExportFormat.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExportFormat.of(ObjectMappers.JSON_MAPPER.convertValue(value, PptxExportFormat.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExportFormat.of(ObjectMappers.JSON_MAPPER.convertValue(value, GifExportFormat.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExportFormat.of(ObjectMappers.JSON_MAPPER.convertValue(value, Mp4ExportFormat.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



