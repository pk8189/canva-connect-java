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
@JsonDeserialize(builder = DesignSummary.Builder.class)
public final class DesignSummary {
    /**
     * When the design was created in Canva, as a Unix timestamp (in seconds since the Unix
     * Epoch).
     */
    private final Integer createdAt;
    /**
     * The design ID.
     */
    private final String id;
    private final Optional<Thumbnail> thumbnail;
    /**
     * The design title.
     */
    private final Optional<String> title;
    /**
     * When the design was last updated in Canva, as a Unix timestamp (in seconds since the
     * Unix Epoch).
     */
    private final Integer updatedAt;
    /**
     * URL of the design.
     */
    private final Optional<String> url;
    private final DesignLinks urls;

    private DesignSummary(
        Integer createdAt,
        String id,
        Optional<Thumbnail> thumbnail,
        Optional<String> title,
        Integer updatedAt,
        Optional<String> url,
        DesignLinks urls
    ) {
        this.createdAt = createdAt;
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.updatedAt = updatedAt;
        this.url = url;
        this.urls = urls;
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
        return title.orElse(null);
    }

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("url")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUrl() {
        return url.orElse(null);
    }

    @JsonProperty("urls")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignLinks getUrls() {
        return urls;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignSummary && equalTo((DesignSummary) other);
    }

    private boolean equalTo(DesignSummary other) {
        return
            createdAt.equals(other.createdAt) &&

            id.equals(other.id) &&

            thumbnail.equals(other.thumbnail) &&

            title.equals(other.title) &&

            updatedAt.equals(other.updatedAt) &&

            url.equals(other.url) &&

            urls.equals(other.urls)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.createdAt,
                   this.id,
                   this.thumbnail,
                   this.title,
                   this.updatedAt,
                   this.url,
                   this.urls
               );
    }

    @Override
    public String toString() {
        return "DesignSummary{" +
               "createdAt=" + createdAt +
               "id=" + id +
               "thumbnail=" + thumbnail +
               "title=" + title +
               "updatedAt=" + updatedAt +
               "url=" + url +
               "urls=" + urls +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer createdAt = null;
        private String id = null;
        private Optional<Thumbnail> thumbnail = Optional.empty();
        private Optional<String> title = Optional.empty();
        private Integer updatedAt = null;
        private Optional<String> url = Optional.empty();
        private DesignLinks urls = null;

        private Builder() {}

        public Builder from(DesignSummary other) {
            createdAt(other.getCreatedAt());
            id(other.getId());
            thumbnail(other.getThumbnail());
            title(other.getTitle());
            updatedAt(other.getUpdatedAt());
            url(other.getUrl());
            urls(other.getUrls());
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
            this.title = Optional.ofNullable(title);
            return this;
        }

        public Builder title(Optional<String> title) {
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


        @JsonSetter("url")
        public Builder url(String url) {
            this.url = Optional.ofNullable(url);
            return this;
        }

        public Builder url(Optional<String> url) {
            this.url = url;
            return this;
        }

        @JsonSetter("urls")
        public Builder urls(DesignLinks urls) {
            if (urls == null) {
                throw new IllegalArgumentException("urls cannot be null");
            }

            this.urls = urls;
            return this;
        }



        public DesignSummary build() {
            if (createdAt == null) {
                throw new IllegalStateException("createdAt is required");
            }

            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (updatedAt == null) {
                throw new IllegalStateException("updatedAt is required");
            }

            if (urls == null) {
                throw new IllegalStateException("urls is required");
            }

            return new DesignSummary(
                       createdAt,
                       id,
                       thumbnail,
                       title,
                       updatedAt,
                       url,
                       urls
                   );
        }
    }

}




