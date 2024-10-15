package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DatasetImageValue.Builder.class)
public final class DatasetImageValue {
    /**
     * &#x60;asset_id&#x60; of the image to insert into the template element.
     */
    private final String assetId;
    private final DatasetImageValueTypeEnum type;

    private DatasetImageValue(
        String assetId,
        DatasetImageValueTypeEnum type
    ) {
        this.assetId = assetId;
        this.type = type;
    }

    @JsonProperty("asset_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAssetId() {
        return assetId;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DatasetImageValueTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DatasetImageValue && equalTo((DatasetImageValue) other);
    }

    private boolean equalTo(DatasetImageValue other) {
        return
            assetId.equals(other.assetId) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assetId,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "DatasetImageValue{" +
               "assetId=" + assetId +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String assetId = null;
        private DatasetImageValueTypeEnum type = null;

        private Builder() {}

        public Builder from(DatasetImageValue other) {
            assetId(other.getAssetId());
            type(other.getType());
            return this;
        }

        @JsonSetter("asset_id")
        public Builder assetId(String assetId) {
            if (assetId == null) {
                throw new IllegalArgumentException("assetId cannot be null");
            }

            this.assetId = assetId;
            return this;
        }


        @JsonSetter("type")
        public Builder type(DatasetImageValueTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public DatasetImageValue build() {
            if (assetId == null) {
                throw new IllegalStateException("assetId is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DatasetImageValue(
                       assetId,
                       type
                   );
        }
    }

}




