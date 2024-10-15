package com.canva.canvaconnectapi.resources.v1.comments.replies.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.CreateReplyRequest;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateRequest.Builder.class)
public final class CreateRequest {
    private final String commentId;
    private final CreateReplyRequest data;

    private CreateRequest(
        String commentId,
        CreateReplyRequest data
    ) {
        this.commentId = commentId;
        this.data = data;
    }

    @JsonProperty("commentId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getCommentId() {
        return commentId;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public CreateReplyRequest getData() {
        return data;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateRequest && equalTo((CreateRequest) other);
    }

    private boolean equalTo(CreateRequest other) {
        return
            commentId.equals(other.commentId) &&

            data.equals(other.data)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.commentId,
                   this.data
               );
    }

    @Override
    public String toString() {
        return "CreateRequest{" +
               "commentId=" + commentId +
               "data=" + data +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String commentId = null;
        private CreateReplyRequest data = null;

        private Builder() {}

        public Builder from(CreateRequest other) {
            commentId(other.getCommentId());
            data(other.getData());
            return this;
        }

        @JsonSetter("commentId")
        public Builder commentId(String commentId) {
            if (commentId == null) {
                throw new IllegalArgumentException("commentId cannot be null");
            }

            this.commentId = commentId;
            return this;
        }


        @JsonSetter("data")
        public Builder data(CreateReplyRequest data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }



        public CreateRequest build() {
            if (commentId == null) {
                throw new IllegalStateException("commentId is required");
            }

            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new CreateRequest(
                       commentId,
                       data
                   );
        }
    }

}




