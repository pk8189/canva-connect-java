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
@JsonDeserialize(builder = CreateCommentRequest.Builder.class)
public final class CreateCommentRequest {
    /**
     * Lets you assign the comment to a Canva user using their User ID. You _must_ mention the
     * assigned user in the &#x60;message&#x60;.
     */
    private final Optional<String> assigneeId;
    private final DesignCommentObjectInput attachedTo;
    /**
     * The comment message. This is the comment body shown in the Canva UI.
     *
     * You can also mention users in your message by specifying their User ID and Team ID
     * using the format &#x60;[user_id:team_id]&#x60;. If the &#x60;assignee_id&#x60; parameter is specified, you
     * must mention the assignee in the message.
     */
    private final String message;

    private CreateCommentRequest(
        Optional<String> assigneeId,
        DesignCommentObjectInput attachedTo,
        String message
    ) {
        this.assigneeId = assigneeId;
        this.attachedTo = attachedTo;
        this.message = message;
    }

    @JsonProperty("assignee_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getAssigneeId() {
        return assigneeId.orElse(null);
    }

    @JsonProperty("attached_to")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignCommentObjectInput getAttachedTo() {
        return attachedTo;
    }

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getMessage() {
        return message;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateCommentRequest && equalTo((CreateCommentRequest) other);
    }

    private boolean equalTo(CreateCommentRequest other) {
        return
            assigneeId.equals(other.assigneeId) &&

            attachedTo.equals(other.attachedTo) &&

            message.equals(other.message)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.assigneeId,
                   this.attachedTo,
                   this.message
               );
    }

    @Override
    public String toString() {
        return "CreateCommentRequest{" +
               "assigneeId=" + assigneeId +
               "attachedTo=" + attachedTo +
               "message=" + message +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> assigneeId = Optional.empty();
        private DesignCommentObjectInput attachedTo = null;
        private String message = null;

        private Builder() {}

        public Builder from(CreateCommentRequest other) {
            assigneeId(other.getAssigneeId());
            attachedTo(other.getAttachedTo());
            message(other.getMessage());
            return this;
        }

        @JsonSetter("assignee_id")
        public Builder assigneeId(String assigneeId) {
            this.assigneeId = Optional.ofNullable(assigneeId);
            return this;
        }

        public Builder assigneeId(Optional<String> assigneeId) {
            this.assigneeId = assigneeId;
            return this;
        }

        @JsonSetter("attached_to")
        public Builder attachedTo(DesignCommentObjectInput attachedTo) {
            if (attachedTo == null) {
                throw new IllegalArgumentException("attachedTo cannot be null");
            }

            this.attachedTo = attachedTo;
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



        public CreateCommentRequest build() {
            if (attachedTo == null) {
                throw new IllegalStateException("attachedTo is required");
            }

            if (message == null) {
                throw new IllegalStateException("message is required");
            }

            return new CreateCommentRequest(
                       assigneeId,
                       attachedTo,
                       message
                   );
        }
    }

}




