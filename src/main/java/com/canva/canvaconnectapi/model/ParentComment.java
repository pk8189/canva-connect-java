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
@JsonDeserialize(builder = ParentComment.Builder.class)
public final class ParentComment {
    private final Optional<User> assignee;
    private final Optional<DesignCommentObject> attachedTo;
    private final User author;
    /**
     * When the comment or reply was created, as a Unix timestamp
     * (in seconds since the Unix Epoch).
     */
    private final Optional<Integer> createdAt;
    /**
     * The ID of the comment.
     *
     * You can use this ID to create replies to the comment using the [Create reply API](https://www.canva.dev/docs/connect/api-reference/comments/create-reply/).
     */
    private final String id;
    /**
     * The Canva users mentioned in the comment.
     */
    private final ParentCommentMentions mentions;
    /**
     * The comment message. This is the comment body shown in the Canva UI.
     * User mentions are shown here in the format &#x60;[user_id:team_id]&#x60;.
     */
    private final String message;
    private final Optional<User> resolver;
    private final ParentCommentTypeEnum type;
    /**
     * When the comment or reply was last updated, as a Unix timestamp
     * (in seconds since the Unix Epoch).
     */
    private final Optional<Integer> updatedAt;

    private ParentComment(
        Optional<User> assignee,
        Optional<DesignCommentObject> attachedTo,
        User author,
        Optional<Integer> createdAt,
        String id,
        ParentCommentMentions mentions,
        String message,
        Optional<User> resolver,
        ParentCommentTypeEnum type,
        Optional<Integer> updatedAt
    ) {
        this.assignee = assignee;
        this.attachedTo = attachedTo;
        this.author = author;
        this.createdAt = createdAt;
        this.id = id;
        this.mentions = mentions;
        this.message = message;
        this.resolver = resolver;
        this.type = type;
        this.updatedAt = updatedAt;
    }

    @JsonProperty("assignee")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public User getAssignee() {
        return assignee.orElse(null);
    }

    @JsonProperty("attached_to")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignCommentObject getAttachedTo() {
        return attachedTo.orElse(null);
    }

    @JsonProperty("author")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public User getAuthor() {
        return author;
    }

    @JsonProperty("created_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getCreatedAt() {
        return createdAt.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }

    @JsonProperty("mentions")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ParentCommentMentions getMentions() {
        return mentions;
    }

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getMessage() {
        return message;
    }

    @JsonProperty("resolver")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public User getResolver() {
        return resolver.orElse(null);
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ParentCommentTypeEnum getType() {
        return type;
    }

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Integer getUpdatedAt() {
        return updatedAt.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ParentComment && equalTo((ParentComment) other);
    }

    private boolean equalTo(ParentComment other) {
        return
            assignee.equals(other.assignee) &&

            attachedTo.equals(other.attachedTo) &&

            author.equals(other.author) &&

            createdAt.equals(other.createdAt) &&

            id.equals(other.id) &&

            mentions.equals(other.mentions) &&

            message.equals(other.message) &&

            resolver.equals(other.resolver) &&

            type.equals(other.type) &&

            updatedAt.equals(other.updatedAt)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assignee,
                   this.attachedTo,
                   this.author,
                   this.createdAt,
                   this.id,
                   this.mentions,
                   this.message,
                   this.resolver,
                   this.type,
                   this.updatedAt
               );
    }

    @Override
    public String toString() {
        return "ParentComment{" +
               "assignee=" + assignee +
               "attachedTo=" + attachedTo +
               "author=" + author +
               "createdAt=" + createdAt +
               "id=" + id +
               "mentions=" + mentions +
               "message=" + message +
               "resolver=" + resolver +
               "type=" + type +
               "updatedAt=" + updatedAt +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<User> assignee = Optional.empty();
        private Optional<DesignCommentObject> attachedTo = Optional.empty();
        private User author = null;
        private Optional<Integer> createdAt = Optional.empty();
        private String id = null;
        private ParentCommentMentions mentions = null;
        private String message = null;
        private Optional<User> resolver = Optional.empty();
        private ParentCommentTypeEnum type = null;
        private Optional<Integer> updatedAt = Optional.empty();

        private Builder() {}

        public Builder from(ParentComment other) {
            assignee(other.getAssignee());
            attachedTo(other.getAttachedTo());
            author(other.getAuthor());
            createdAt(other.getCreatedAt());
            id(other.getId());
            mentions(other.getMentions());
            message(other.getMessage());
            resolver(other.getResolver());
            type(other.getType());
            updatedAt(other.getUpdatedAt());
            return this;
        }

        @JsonSetter("assignee")
        public Builder assignee(User assignee) {
            this.assignee = Optional.ofNullable(assignee);
            return this;
        }

        public Builder assignee(Optional<User> assignee) {
            this.assignee = assignee;
            return this;
        }

        @JsonSetter("attached_to")
        public Builder attachedTo(DesignCommentObject attachedTo) {
            this.attachedTo = Optional.ofNullable(attachedTo);
            return this;
        }

        public Builder attachedTo(Optional<DesignCommentObject> attachedTo) {
            this.attachedTo = attachedTo;
            return this;
        }

        @JsonSetter("author")
        public Builder author(User author) {
            if (author == null) {
                throw new IllegalArgumentException("author cannot be null");
            }

            this.author = author;
            return this;
        }


        @JsonSetter("created_at")
        public Builder createdAt(Integer createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        public Builder createdAt(Optional<Integer> createdAt) {
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


        @JsonSetter("mentions")
        public Builder mentions(ParentCommentMentions mentions) {
            if (mentions == null) {
                throw new IllegalArgumentException("mentions cannot be null");
            }

            this.mentions = mentions;
            return this;
        }


        @JsonSetter("message")
        public Builder message(String message) {
            if (message == null) {
                throw new IllegalArgumentException("message cannot be null");
            }

            this.message = message;
            return this;
        }


        @JsonSetter("resolver")
        public Builder resolver(User resolver) {
            this.resolver = Optional.ofNullable(resolver);
            return this;
        }

        public Builder resolver(Optional<User> resolver) {
            this.resolver = resolver;
            return this;
        }

        @JsonSetter("type")
        public Builder type(ParentCommentTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }


        @JsonSetter("updated_at")
        public Builder updatedAt(Integer updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        public Builder updatedAt(Optional<Integer> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }


        public ParentComment build() {
            if (author == null) {
                throw new IllegalStateException("author is required");
            }

            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            if (mentions == null) {
                throw new IllegalStateException("mentions is required");
            }

            if (message == null) {
                throw new IllegalStateException("message is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new ParentComment(
                       assignee,
                       attachedTo,
                       author,
                       createdAt,
                       id,
                       mentions,
                       message,
                       resolver,
                       type,
                       updatedAt
                   );
        }
    }

}




