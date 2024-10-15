package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DesignCommentObject.Builder.class)
public final class DesignCommentObject {
    /**
     * The ID of the design this comment is attached to.
     */
    private final String designId;
    private final DesignCommentObjectTypeEnum type;

    private DesignCommentObject(
        String designId,
        DesignCommentObjectTypeEnum type
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
    public DesignCommentObjectTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignCommentObject && equalTo((DesignCommentObject) other);
    }

    private boolean equalTo(DesignCommentObject other) {
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
        return "DesignCommentObject{" +
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
        private DesignCommentObjectTypeEnum type = null;

        private Builder() {}

        public Builder from(DesignCommentObject other) {
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
        public Builder type(DesignCommentObjectTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public DesignCommentObject build() {
            if (designId == null) {
                throw new IllegalStateException("designId is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DesignCommentObject(
                       designId,
                       type
                   );
        }
    }

}




