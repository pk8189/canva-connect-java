package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Thumbnail.Builder.class)
public final class Thumbnail {
    /**
     * The height of the thumbnail image in pixels.
     */
    private final Integer height;
    /**
     * A URL for retrieving the thumbnail image.
     * This URL expires after 15 minutes. This URL includes a query string
     * that&#x27;s required for retrieving the thumbnail.
     */
    private final String url;
    /**
     * The width of the thumbnail image in pixels.
     */
    private final Integer width;

    private Thumbnail(
        Integer height,
        String url,
        Integer width
    ) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    @JsonProperty("height")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("url")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUrl() {
        return url;
    }

    @JsonProperty("width")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getWidth() {
        return width;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof Thumbnail && equalTo((Thumbnail) other);
    }

    private boolean equalTo(Thumbnail other) {
        return
            height.equals(other.height) &&

            url.equals(other.url) &&

            width.equals(other.width)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.height,
                   this.url,
                   this.width
               );
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
               "height=" + height +
               "url=" + url +
               "width=" + width +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer height = null;
        private String url = null;
        private Integer width = null;

        private Builder() {}

        public Builder from(Thumbnail other) {
            height(other.getHeight());
            url(other.getUrl());
            width(other.getWidth());
            return this;
        }

        @JsonSetter("height")
        public Builder height(Integer height) {
            if (height == null) {
                throw new IllegalArgumentException("height cannot be null");
            }

            this.height = height;
            return this;
        }


        @JsonSetter("url")
        public Builder url(String url) {
            if (url == null) {
                throw new IllegalArgumentException("url cannot be null");
            }

            this.url = url;
            return this;
        }


        @JsonSetter("width")
        public Builder width(Integer width) {
            if (width == null) {
                throw new IllegalArgumentException("width cannot be null");
            }

            this.width = width;
            return this;
        }



        public Thumbnail build() {
            if (height == null) {
                throw new IllegalStateException("height is required");
            }

            if (url == null) {
                throw new IllegalStateException("url is required");
            }

            if (width == null) {
                throw new IllegalStateException("width is required");
            }

            return new Thumbnail(
                       height,
                       url,
                       width
                   );
        }
    }

}




