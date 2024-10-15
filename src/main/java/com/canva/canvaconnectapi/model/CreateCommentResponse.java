package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateCommentResponse.Builder.class)
public final class CreateCommentResponse {
    private final ParentComment comment;

    private CreateCommentResponse(
        ParentComment comment
    ) {
        this.comment = comment;
    }

    @JsonProperty("comment")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ParentComment getComment() {
        return comment;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateCommentResponse && equalTo((CreateCommentResponse) other);
    }

    private boolean equalTo(CreateCommentResponse other) {
        return
            comment.equals(other.comment)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.comment
               );
    }

    @Override
    public String toString() {
        return "CreateCommentResponse{" +
               "comment=" + comment +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private ParentComment comment = null;

        private Builder() {}

        public Builder from(CreateCommentResponse other) {
            comment(other.getComment());
            return this;
        }

        @JsonSetter("comment")
        public Builder comment(ParentComment comment) {
            if (comment == null) {
                throw new IllegalArgumentException("comment cannot be null");
            }

            this.comment = comment;
            return this;
        }



        public CreateCommentResponse build() {
            if (comment == null) {
                throw new IllegalStateException("comment is required");
            }

            return new CreateCommentResponse(
                       comment
                   );
        }
    }

}




