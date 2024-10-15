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
@JsonDeserialize(builder = UpdateAssetRequest.Builder.class)
public final class UpdateAssetRequest {
    /**
     * The name of the asset. This is shown in the Canva UI.
     * When this field is undefined, nothing is updated.
     * Maximum length 50 characters.
     */
    private final Optional<String> name;
    /**
     * The replacement tags for the asset.
     * When this field is undefined, nothing is updated.
     * Maximum length 50 tags. Each tag
     * has a maximum length of 50 characters.
     */
    private final Optional<List<String>> tags;

    private UpdateAssetRequest(
        Optional<String> name,
        Optional<List<String>> tags
    ) {
        this.name = name;
        this.tags = tags;
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getName() {
        return name.orElse(null);
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<String> getTags() {
        return tags.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UpdateAssetRequest && equalTo((UpdateAssetRequest) other);
    }

    private boolean equalTo(UpdateAssetRequest other) {
        return
            name.equals(other.name) &&

            tags.equals(other.tags)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.name,
                   this.tags
               );
    }

    @Override
    public String toString() {
        return "UpdateAssetRequest{" +
               "name=" + name +
               "tags=" + tags +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> name = Optional.empty();
        private Optional<List<String>> tags = Optional.empty();

        private Builder() {}

        public Builder from(UpdateAssetRequest other) {
            name(other.getName());
            tags(other.getTags());
            return this;
        }

        @JsonSetter("name")
        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        @JsonSetter("tags")
        public Builder tags(List<String> tags) {
            this.tags = Optional.ofNullable(tags);
            return this;
        }

        public Builder tags(Optional<List<String>> tags) {
            this.tags = tags;
            return this;
        }


        public UpdateAssetRequest build() {
            return new UpdateAssetRequest(
                       name,
                       tags
                   );
        }
    }

}




