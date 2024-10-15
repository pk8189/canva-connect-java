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
@JsonDeserialize(builder = Folder.Builder.class)
public final class Folder {
    /**
     * When the folder was created, as a Unix timestamp (in seconds since the
     * Unix Epoch).
     */
    private final Integer createdAt;
    /**
     * The folder ID.
     */
    private final String id;
    /**
     * The folder name.
     */
    private final String name;
    private final Optional<Thumbnail> thumbnail;
    /**
     * When the folder was last updated, as a Unix timestamp (in seconds since the
     * Unix Epoch).
     */
    private final Integer updatedAt;

    private Folder(
        Integer createdAt,
        String id,
        String name,
        Optional<Thumbnail> thumbnail,
        Integer updatedAt
    ) {
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
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

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getName() {
        return name;
    }

    @JsonProperty("thumbnail")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Thumbnail getThumbnail() {
        return thumbnail.orElse(null);
    }

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getUpdatedAt() {
        return updatedAt;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof Folder && equalTo((Folder) other);
    }

    private boolean equalTo(Folder other) {
        return
            createdAt.equals(other.createdAt) &&

            id.equals(other.id) &&

            name.equals(other.name) &&

            thumbnail.equals(other.thumbnail) &&

            updatedAt.equals(other.updatedAt)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.createdAt,
                   this.id,
                   this.name,
                   this.thumbnail,
                   this.updatedAt
               );
    }

    @Override
    public String toString() {
        return "Folder{" +
               "createdAt=" + createdAt +
               "id=" + id +
               "name=" + name +
               "thumbnail=" + thumbnail +
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
        private String name = null;
        private Optional<Thumbnail> thumbnail = Optional.empty();
        private Integer updatedAt = null;

        private Builder() {}

        public Builder from(Folder other) {
            createdAt(other.getCreatedAt());
            id(other.getId());
            name(other.getName());
            thumbnail(other.getThumbnail());
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


        @JsonSetter("name")
        public Builder name(String name) {
            if (name == null) {
                throw new IllegalArgumentException("name cannot be null");
            }

            this.name = name;
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

        @JsonSetter("updated_at")
        public Builder updatedAt(Integer updatedAt) {
            if (updatedAt == null) {
                throw new IllegalArgumentException("updatedAt cannot be null");
            }

            this.updatedAt = updatedAt;
            return this;
        }



        public Folder build() {
            if (createdAt == null) {
                throw new IllegalStateException("createdAt is required");
            }

            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (name == null) {
                throw new IllegalStateException("name is required");
            }

            if (updatedAt == null) {
                throw new IllegalStateException("updatedAt is required");
            }

            return new Folder(
                       createdAt,
                       id,
                       name,
                       thumbnail,
                       updatedAt
                   );
        }
    }

}




