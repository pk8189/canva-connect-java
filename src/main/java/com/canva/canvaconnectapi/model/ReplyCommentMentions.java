package com.canva.canvaconnectapi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ReplyCommentMentions.Builder.class)
public final class ReplyCommentMentions {
    private final Map<String, TeamUser> additionalProperties;

    private ReplyCommentMentions(

        Map<String, TeamUser> additionalProperties
    ) {
        this.additionalProperties = additionalProperties;
    }

    @JsonAnyGetter
    public Map<String, TeamUser> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ReplyCommentMentions && equalTo((ReplyCommentMentions) other);
    }

    private boolean equalTo(ReplyCommentMentions other) {
        return
            additionalProperties.equals(other.additionalProperties)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(

                   this.additionalProperties
               );
    }

    @Override
    public String toString() {
        return "ReplyCommentMentions{" +
               ", additionalProperties=" + additionalProperties +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<String, TeamUser> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ReplyCommentMentions other) {
            additionalProperties(other.getAdditionalProperties());
            return this;
        }

        @JsonAnySetter
        public Builder additionalProperty(String key, TeamUser value) {
            this.additionalProperties.put(key, value);
            return this;
        }

        public Builder additionalProperties(Map<String, TeamUser> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        public ReplyCommentMentions build() {
            return new ReplyCommentMentions(

                       additionalProperties
                   );
        }
    }

}




