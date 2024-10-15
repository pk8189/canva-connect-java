package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ImageItem.Builder.class)
public final class ImageItem {
    private final AssetSummary image;
    private final ImageItemTypeEnum type;

    private ImageItem(
        AssetSummary image,
        ImageItemTypeEnum type
    ) {
        this.image = image;
        this.type = type;
    }

    @JsonProperty("image")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetSummary getImage() {
        return image;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ImageItemTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ImageItem && equalTo((ImageItem) other);
    }

    private boolean equalTo(ImageItem other) {
        return
            image.equals(other.image) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.image,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "ImageItem{" +
               "image=" + image +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private AssetSummary image = null;
        private ImageItemTypeEnum type = null;

        private Builder() {}

        public Builder from(ImageItem other) {
            image(other.getImage());
            type(other.getType());
            return this;
        }

        @JsonSetter("image")
        public Builder image(AssetSummary image) {
            if (image == null) {
                throw new IllegalArgumentException("image cannot be null");
            }

            this.image = image;
            return this;
        }


        @JsonSetter("type")
        public Builder type(ImageItemTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public ImageItem build() {
            if (image == null) {
                throw new IllegalStateException("image is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new ImageItem(
                       image,
                       type
                   );
        }
    }

}




