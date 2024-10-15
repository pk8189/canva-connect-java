package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DesignCommentObjectInput.Builder.class)
public final class DesignCommentObjectInput {
    /**
     * The ID of the design you want to attach this comment to.
     */
    private final String designId;
    private final DesignCommentObjectInputTypeEnum type;

    private DesignCommentObjectInput(
        String designId,
        DesignCommentObjectInputTypeEnum type
    ) {
        this.designId = designId;
        this.type = type;
    }

    @JsonProperty("design_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDesignId() {
        return designId;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DesignCommentObjectInputTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignCommentObjectInput && equalTo((DesignCommentObjectInput) other);
    }

    private boolean equalTo(DesignCommentObjectInput other) {
        return
            designId.equals(other.designId) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.designId,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "DesignCommentObjectInput{" +
               "designId=" + designId +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String designId = null;
        private DesignCommentObjectInputTypeEnum type = null;

        private Builder() {}

        public Builder from(DesignCommentObjectInput other) {
            designId(other.getDesignId());
            type(other.getType());
            return this;
        }

        @JsonSetter("design_id")
        public Builder designId(String designId) {
            if (designId == null) {
                throw new IllegalArgumentException("designId cannot be null");
            }

            this.designId = designId;
            return this;
        }


        @JsonSetter("type")
        public Builder type(DesignCommentObjectInputTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public DesignCommentObjectInput build() {
            if (designId == null) {
                throw new IllegalStateException("designId is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DesignCommentObjectInput(
                       designId,
                       type
                   );
        }
    }

}




