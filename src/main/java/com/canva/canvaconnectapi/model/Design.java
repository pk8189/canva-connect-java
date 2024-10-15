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
@JsonDeserialize(builder = Design.Builder.class)
public final class Design {
    /**
     * When the design was created in Canva, as a Unix timestamp (in seconds since the Unix
     * Epoch).
     */
    private final Integer createdAt;
    /**
     * The design ID.
     */
    private final String id;
    private final TeamUserSummary owner;
    /**
     * The total number of pages in the design. Some design types don&#x27;t have pages (for example, Canva docs).
     */
    private final Optional<Integer> pageCount;
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
    private final DesignLinks urls;

    private Design(
        Integer createdAt,
        String id,
        TeamUserSummary owner,
        Optional<Integer> pageCount,
        Optional<Thumbnail> thumbnail,
        Optional<String> title,
        Integer updatedAt,
        DesignLinks urls
    ) {
        this.createdAt = createdAt;
        this.id = id;
        this.owner = owner;
        this.pageCount = pageCount;
        this.thumbnail = thumbnail;
        this.title = title;
        this.updatedAt = updatedAt;
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

    @JsonProperty("owner")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public TeamUserSummary getOwner() {
        return owner;
    }

    @JsonProperty("page_count")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getPageCount() {
        return pageCount.orElse(null);
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

    @JsonProperty("urls")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignLinks getUrls() {
        return urls;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof Design && equalTo((Design) other);
    }

    private boolean equalTo(Design other) {
        return
            createdAt.equals(other.createdAt) &&

            id.equals(other.id) &&

            owner.equals(other.owner) &&

            pageCount.equals(other.pageCount) &&

            thumbnail.equals(other.thumbnail) &&

            title.equals(other.title) &&

            updatedAt.equals(other.updatedAt) &&

            urls.equals(other.urls)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.createdAt,
                   this.id,
                   this.owner,
                   this.pageCount,
                   this.thumbnail,
                   this.title,
                   this.updatedAt,
                   this.urls
               );
    }

    @Override
    public String toString() {
        return "Design{" +
               "createdAt=" + createdAt +
               "id=" + id +
               "owner=" + owner +
               "pageCount=" + pageCount +
               "thumbnail=" + thumbnail +
               "title=" + title +
               "updatedAt=" + updatedAt +
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
        private TeamUserSummary owner = null;
        private Optional<Integer> pageCount = Optional.empty();
        private Optional<Thumbnail> thumbnail = Optional.empty();
        private Optional<String> title = Optional.empty();
        private Integer updatedAt = null;
        private DesignLinks urls = null;

        private Builder() {}

        public Builder from(Design other) {
            createdAt(other.getCreatedAt());
            id(other.getId());
            owner(other.getOwner());
            pageCount(other.getPageCount());
            thumbnail(other.getThumbnail());
            title(other.getTitle());
            updatedAt(other.getUpdatedAt());
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


        @JsonSetter("owner")
        public Builder owner(TeamUserSummary owner) {
            if (owner == null) {
                throw new IllegalArgumentException("owner cannot be null");
            }

            this.owner = owner;
            return this;
        }


        @JsonSetter("page_count")
        public Builder pageCount(Integer pageCount) {
            this.pageCount = Optional.ofNullable(pageCount);
            return this;
        }

        public Builder pageCount(Optional<Integer> pageCount) {
            this.pageCount = pageCount;
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


        @JsonSetter("urls")
        public Builder urls(DesignLinks urls) {
            if (urls == null) {
                throw new IllegalArgumentException("urls cannot be null");
            }

            this.urls = urls;
            return this;
        }



        public Design build() {
            if (createdAt == null) {
                throw new IllegalStateException("createdAt is required");
            }

            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (owner == null) {
                throw new IllegalStateException("owner is required");
            }

            if (updatedAt == null) {
                throw new IllegalStateException("updatedAt is required");
            }

            if (urls == null) {
                throw new IllegalStateException("urls is required");
            }

            return new Design(
                       createdAt,
                       id,
                       owner,
                       pageCount,
                       thumbnail,
                       title,
                       updatedAt,
                       urls
                   );
        }
    }

}




