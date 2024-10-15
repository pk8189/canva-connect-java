package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateReplyRequest.Builder.class)
public final class CreateReplyRequest {
    private final DesignCommentObjectInput attachedTo;
    /**
     * The reply comment message. This is the reply comment body shown in the Canva UI.
     *
     * You can also mention users in your message by specifying their User ID and Team ID
     * using the format &#x60;[user_id:team_id]&#x60;.
     */
    private final String message;

    private CreateReplyRequest(
        DesignCommentObjectInput attachedTo,
        String message
    ) {
        this.attachedTo = attachedTo;
        this.message = message;
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

        return other instanceof CreateReplyRequest && equalTo((CreateReplyRequest) other);
    }

    private boolean equalTo(CreateReplyRequest other) {
        return
            attachedTo.equals(other.attachedTo) &&

            message.equals(other.message)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.attachedTo,
                   this.message
               );
    }

    @Override
    public String toString() {
        return "CreateReplyRequest{" +
               "attachedTo=" + attachedTo +
               "message=" + message +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DesignCommentObjectInput attachedTo = null;
        private String message = null;

        private Builder() {}

        public Builder from(CreateReplyRequest other) {
            attachedTo(other.getAttachedTo());
            message(other.getMessage());
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



        public CreateReplyRequest build() {
            if (attachedTo == null) {
                throw new IllegalStateException("attachedTo is required");
            }

            if (message == null) {
                throw new IllegalStateException("message is required");
            }

            return new CreateReplyRequest(
                       attachedTo,
                       message
                   );
        }
    }

}




