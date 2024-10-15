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
@JsonDeserialize(builder = PptxExportFormat.Builder.class)
public final class PptxExportFormat {
    /**
     * To specify which pages to export in a multi-page design, provide the page numbers as
     * an array. The first page in a design is page &#x60;1&#x60;.
     * If &#x60;pages&#x60; isn&#x27;t specified, all the pages are exported.
     */
    private final Optional<List<Integer>> pages;
    private final PptxExportFormatTypeEnum type;

    private PptxExportFormat(
        Optional<List<Integer>> pages,
        PptxExportFormatTypeEnum type
    ) {
        this.pages = pages;
        this.type = type;
    }

    @JsonProperty("pages")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<Integer> getPages() {
        return pages.orElse(null);
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public PptxExportFormatTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof PptxExportFormat && equalTo((PptxExportFormat) other);
    }

    private boolean equalTo(PptxExportFormat other) {
        return
            pages.equals(other.pages) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.pages,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "PptxExportFormat{" +
               "pages=" + pages +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Integer>> pages = Optional.empty();
        private PptxExportFormatTypeEnum type = null;

        private Builder() {}

        public Builder from(PptxExportFormat other) {
            pages(other.getPages());
            type(other.getType());
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
        public Builder type(PptxExportFormatTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public PptxExportFormat build() {
            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new PptxExportFormat(
                       pages,
                       type
                   );
        }
    }

}




