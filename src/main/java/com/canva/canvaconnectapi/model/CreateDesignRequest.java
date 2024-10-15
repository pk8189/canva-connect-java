package com.canva.canvaconnectapi.model;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateDesignRequest.Builder.class)
public final class CreateDesignRequest {
    /**
     * The ID of an asset to insert into the created design.
     */
    private final Optional<String> assetId;
    private final Optional<DesignTypeInput> designType;
    /**
     * The name of the design. Must be less than 256 characters.
     */
    private final Optional<String> title;

    private CreateDesignRequest(
        Optional<String> assetId,
        Optional<DesignTypeInput> designType,
        Optional<String> title
    ) {
        this.assetId = assetId;
        this.designType = designType;
        this.title = title;
    }

    @JsonProperty("asset_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAssetId() {
        return assetId.orElse(null);
    }

    @JsonProperty("design_type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignTypeInput getDesignType() {
        return designType.orElse(null);
    }

    @JsonProperty("title")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTitle() {
        return title.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateDesignRequest && equalTo((CreateDesignRequest) other);
    }

    private boolean equalTo(CreateDesignRequest other) {
        return
            assetId.equals(other.assetId) &&

            designType.equals(other.designType) &&

            title.equals(other.title)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assetId,
                   this.designType,
                   this.title
               );
    }

    @Override
    public String toString() {
        return "CreateDesignRequest{" +
               "assetId=" + assetId +
               "designType=" + designType +
               "title=" + title +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> assetId = Optional.empty();
        private Optional<DesignTypeInput> designType = Optional.empty();
        private Optional<String> title = Optional.empty();

        private Builder() {}

        public Builder from(CreateDesignRequest other) {
            assetId(other.getAssetId());
            designType(other.getDesignType());
            title(other.getTitle());
            return this;
        }

        @JsonSetter("asset_id")
        public Builder assetId(String assetId) {
            this.assetId = Optional.ofNullable(assetId);
            return this;
        }

        public Builder assetId(Optional<String> assetId) {
            this.assetId = assetId;
            return this;
        }

        @JsonSetter("design_type")
        public Builder designType(DesignTypeInput designType) {
            this.designType = Optional.ofNullable(designType);
            return this;
        }

        public Builder designType(Optional<DesignTypeInput> designType) {
            this.designType = designType;
            return this;
        }

        @JsonSetter("title")
        public Builder title(String title) {
            this.title = Optional.ofNullable(title);
            return this;
        }

        public Builder title(Optional<String> title) {
            this.title = title;
            return this;
        }


        public CreateDesignRequest build() {
            return new CreateDesignRequest(
                       assetId,
                       designType,
                       title
                   );
        }
    }

}




