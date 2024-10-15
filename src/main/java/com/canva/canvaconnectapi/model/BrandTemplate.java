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
@JsonDeserialize(builder = BrandTemplate.Builder.class)
public final class BrandTemplate {
    /**
     * A URL Canva users can visit to create a new design from the template.
     */
    private final String createUrl;
    /**
     * When the brand template was created, as a Unix timestamp
     * (in seconds since the Unix Epoch).
     */
    private final Integer createdAt;
    /**
     * The brand template ID.
     */
    private final String id;
    private final Optional<Thumbnail> thumbnail;
    /**
     * The brand template title, as shown in the Canva UI.
     */
    private final String title;
    /**
     * When the brand template was last updated, as a Unix timestamp
     * (in seconds since the Unix Epoch).
     */
    private final Integer updatedAt;
    /**
     * A URL Canva users can visit to view the brand template.
     */
    private final String viewUrl;

    private BrandTemplate(
        String createUrl,
        Integer createdAt,
        String id,
        Optional<Thumbnail> thumbnail,
        String title,
        Integer updatedAt,
        String viewUrl
    ) {
        this.createUrl = createUrl;
        this.createdAt = createdAt;
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.updatedAt = updatedAt;
        this.viewUrl = viewUrl;
    }

    @JsonProperty("create_url")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getCreateUrl() {
        return createUrl;
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

    @JsonProperty("thumbnail")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Thumbnail getThumbnail() {
        return thumbnail.orElse(null);
    }

    @JsonProperty("title")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTitle() {
        return title;
    }

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("view_url")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getViewUrl() {
        return viewUrl;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof BrandTemplate && equalTo((BrandTemplate) other);
    }

    private boolean equalTo(BrandTemplate other) {
        return
            createUrl.equals(other.createUrl) &&

            createdAt.equals(other.createdAt) &&

            id.equals(other.id) &&

            thumbnail.equals(other.thumbnail) &&

            title.equals(other.title) &&

            updatedAt.equals(other.updatedAt) &&

            viewUrl.equals(other.viewUrl)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.createUrl,
                   this.createdAt,
                   this.id,
                   this.thumbnail,
                   this.title,
                   this.updatedAt,
                   this.viewUrl
               );
    }

    @Override
    public String toString() {
        return "BrandTemplate{" +
               "createUrl=" + createUrl +
               "createdAt=" + createdAt +
               "id=" + id +
               "thumbnail=" + thumbnail +
               "title=" + title +
               "updatedAt=" + updatedAt +
               "viewUrl=" + viewUrl +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String createUrl = null;
        private Integer createdAt = null;
        private String id = null;
        private Optional<Thumbnail> thumbnail = Optional.empty();
        private String title = null;
        private Integer updatedAt = null;
        private String viewUrl = null;

        private Builder() {}

        public Builder from(BrandTemplate other) {
            createUrl(other.getCreateUrl());
            createdAt(other.getCreatedAt());
            id(other.getId());
            thumbnail(other.getThumbnail());
            title(other.getTitle());
            updatedAt(other.getUpdatedAt());
            viewUrl(other.getViewUrl());
            return this;
        }

        @JsonSetter("create_url")
        public Builder createUrl(String createUrl) {
            if (createUrl == null) {
                throw new IllegalArgumentException("createUrl cannot be null");
            }

            this.createUrl = createUrl;
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


        @JsonSetter("thumbnail")
        public Builder thumbnail(Thumbnail thumbnail) {
            this.thumbnail = Optional.ofNullable(thumbnail);
            return this;
        }

        public Builder thumbnail(Optional<Thumbnail> thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        @JsonSetter("title")
        public Builder title(String title) {
            if (title == null) {
                throw new IllegalArgumentException("title cannot be null");
            }

            this.title = title;
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


        @JsonSetter("view_url")
        public Builder viewUrl(String viewUrl) {
            if (viewUrl == null) {
                throw new IllegalArgumentException("viewUrl cannot be null");
            }

            this.viewUrl = viewUrl;
            return this;
        }



        public BrandTemplate build() {
            if (createUrl == null) {
                throw new IllegalStateException("createUrl is required");
            }

            if (createdAt == null) {
                throw new IllegalStateException("createdAt is required");
            }

            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (title == null) {
                throw new IllegalStateException("title is required");
            }

            if (updatedAt == null) {
                throw new IllegalStateException("updatedAt is required");
            }

            if (viewUrl == null) {
                throw new IllegalStateException("viewUrl is required");
            }

            return new BrandTemplate(
                       createUrl,
                       createdAt,
                       id,
                       thumbnail,
                       title,
                       updatedAt,
                       viewUrl
                   );
        }
    }

}




