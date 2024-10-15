package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = Comment.Deserializer.class)
public final class Comment {
    private final Object value;

    private Comment(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isParentCommentVariant() {
        return value instanceof ParentComment;
    }

    public ParentComment asParentCommentVariant() {
        return isParentCommentVariant() ? (ParentComment) value : null;
    }

    public boolean isReplyCommentVariant() {
        return value instanceof ReplyComment;
    }

    public ReplyComment asReplyCommentVariant() {
        return isReplyCommentVariant() ? (ReplyComment) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Comment that = (Comment) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Comment of(Object value) {
        if (value instanceof ParentComment || value instanceof ReplyComment) {
            return new Comment(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends com.fasterxml.jackson.databind.JsonDeserializer<Comment> {
        @Override
        public Comment deserialize(com.fasterxml.jackson.core.JsonParser p,
                                   com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return Comment.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return Comment.of(ObjectMappers.JSON_MAPPER.convertValue(value, ParentComment.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return Comment.of(ObjectMappers.JSON_MAPPER.convertValue(value, ReplyComment.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



