package com.canva.canvaconnectapi.resources.v1.designs.comments.params;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetRequest.Builder.class)
public final class GetRequest {
    private final String designId;
    private final String commentId;

    private GetRequest(
        String designId,
        String commentId
    ) {
        this.designId = designId;
        this.commentId = commentId;
    }

    @JsonProperty("designId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDesignId() {
        return designId;
    }

    @JsonProperty("commentId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getCommentId() {
        return commentId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetRequest && equalTo((GetRequest) other);
    }

    private boolean equalTo(GetRequest other) {
        return
            designId.equals(other.designId) &&

            commentId.equals(other.commentId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.designId,
                   this.commentId
               );
    }

    @Override
    public String toString() {
        return "GetRequest{" +
               "designId=" + designId +
               "commentId=" + commentId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String designId = null;
        private String commentId = null;

        private Builder() {}

        public Builder from(GetRequest other) {
            designId(other.getDesignId());
            commentId(other.getCommentId());
            return this;
        }

        @JsonSetter("designId")
        public Builder designId(String designId) {
            if (designId == null) {
                throw new IllegalArgumentException("designId cannot be null");
            }

            this.designId = designId;
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



        public GetRequest build() {
            if (designId == null) {
                throw new IllegalStateException("designId is required");
            }

            if (commentId == null) {
                throw new IllegalStateException("commentId is required");
            }

            return new GetRequest(
                       designId,
                       commentId
                   );
        }
    }

}




