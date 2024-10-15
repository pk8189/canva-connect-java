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
@JsonDeserialize(builder = Asset.Builder.class)
public final class Asset {
    /**
     * When the asset was added to Canva, as a Unix timestamp (in seconds since the Unix
     * Epoch).
     */
    private final Integer createdAt;
    /**
     * The ID of the asset.
     */
    private final String id;
    private final Optional<ImportStatus> importStatus;
    /**
     * The name of the asset.
     */
    private final String name;
    /**
     * The user-facing tags attached to the asset.
     * Users can add these tags to their uploaded assets, and they can search their uploaded
     * assets in the Canva UI by searching for these tags. For information on how users use
     * tags, see the
     * [Canva Help Center page on asset tags](https://www.canva.com/help/add-edit-tags/).
     */
    private final List<String> tags;
    private final Optional<Thumbnail> thumbnail;
    private final AssetTypeEnum type;
    /**
     * When the asset was last updated in Canva, as a Unix timestamp (in seconds since the
     * Unix Epoch).
     */
    private final Integer updatedAt;

    private Asset(
        Integer createdAt,
        String id,
        Optional<ImportStatus> importStatus,
        String name,
        List<String> tags,
        Optional<Thumbnail> thumbnail,
        AssetTypeEnum type,
        Integer updatedAt
    ) {
        this.createdAt = createdAt;
        this.id = id;
        this.importStatus = importStatus;
        this.name = name;
        this.tags = tags;
        this.thumbnail = thumbnail;
        this.type = type;
        this.updatedAt = updatedAt;
    }

    @JsonProperty("created_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }

    @JsonProperty("import_status")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ImportStatus getImportStatus() {
        return importStatus.orElse(null);
    }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getName() {
        return name;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("thumbnail")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Thumbnail getThumbnail() {
        return thumbnail.orElse(null);
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public AssetTypeEnum getType() {
        return type;
    }

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getUpdatedAt() {
        return updatedAt;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof Asset && equalTo((Asset) other);
    }

    private boolean equalTo(Asset other) {
        return
            createdAt.equals(other.createdAt) &&

            id.equals(other.id) &&

            importStatus.equals(other.importStatus) &&

            name.equals(other.name) &&

            tags.equals(other.tags) &&

            thumbnail.equals(other.thumbnail) &&

            type.equals(other.type) &&

            updatedAt.equals(other.updatedAt)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.createdAt,
                   this.id,
                   this.importStatus,
                   this.name,
                   this.tags,
                   this.thumbnail,
                   this.type,
                   this.updatedAt
               );
    }

    @Override
    public String toString() {
        return "Asset{" +
               "createdAt=" + createdAt +
               "id=" + id +
               "importStatus=" + importStatus +
               "name=" + name +
               "tags=" + tags +
               "thumbnail=" + thumbnail +
               "type=" + type +
               "updatedAt=" + updatedAt +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer createdAt = null;
        private String id = null;
        private Optional<ImportStatus> importStatus = Optional.empty();
        private String name = null;
        private List<String> tags = null;
        private Optional<Thumbnail> thumbnail = Optional.empty();
        private AssetTypeEnum type = null;
        private Integer updatedAt = null;

        private Builder() {}

        public Builder from(Asset other) {
            createdAt(other.getCreatedAt());
            id(other.getId());
            importStatus(other.getImportStatus());
            name(other.getName());
            tags(other.getTags());
            thumbnail(other.getThumbnail());
            type(other.getType());
            updatedAt(other.getUpdatedAt());
            return this;
        }

        @JsonSetter("created_at")
        public Builder createdAt(Integer createdAt) {
            if (createdAt == null) {
                throw new IllegalArgumentException("createdAt cannot be null");
            }

            this.createdAt = createdAt;
            return this;
        }


        @JsonSetter("id")
        public Builder id(String id) {
            if (id == null) {
                throw new IllegalArgumentException("id cannot be null");
            }

            this.id = id;
            return this;
        }


        @JsonSetter("import_status")
        public Builder importStatus(ImportStatus importStatus) {
            this.importStatus = Optional.ofNullable(importStatus);
            return this;
        }

        public Builder importStatus(Optional<ImportStatus> importStatus) {
            this.importStatus = importStatus;
            return this;
        }

        @JsonSetter("name")
        public Builder name(String name) {
            if (name == null) {
                throw new IllegalArgumentException("name cannot be null");
            }

            this.name = name;
            return this;
        }


        @JsonSetter("tags")
        public Builder tags(List<String> tags) {
            if (tags == null) {
                throw new IllegalArgumentException("tags cannot be null");
            }

            this.tags = tags;
            return this;
        }


        @JsonSetter("thumbnail")
        public Builder thumbnail(Thumbnail thumbnail) {
            this.thumbnail = Optional.ofNullable(thumbnail);
            return this;
        }

        public Builder thumbnail(Optional<Thumbnail> thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        @JsonSetter("type")
        public Builder type(AssetTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("updated_at")
        public Builder updatedAt(Integer updatedAt) {
            if (updatedAt == null) {
                throw new IllegalArgumentException("updatedAt cannot be null");
            }

            this.updatedAt = updatedAt;
            return this;
        }



        public Asset build() {
            if (createdAt == null) {
                throw new IllegalStateException("createdAt is required");
            }

            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (name == null) {
                throw new IllegalStateException("name is required");
            }

            if (tags == null) {
                throw new IllegalStateException("tags is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            if (updatedAt == null) {
                throw new IllegalStateException("updatedAt is required");
            }

            return new Asset(
                       createdAt,
                       id,
                       importStatus,
                       name,
                       tags,
                       thumbnail,
                       type,
                       updatedAt
                   );
        }
    }

}




