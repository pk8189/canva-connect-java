package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = MoveFolderItemRequest.Builder.class)
public final class MoveFolderItemRequest {
    /**
     * The ID of the item you want to move.
     */
    private final String itemId;
    /**
     * The ID of the folder you want to move the item to (the destination folder).
     * If you want to move the item to the top level of a Canva user&#x27;s
     * [projects](https://www.canva.com/help/find-designs-and-folders/), use the ID &#x60;root&#x60;.
     */
    private final String toFolderId;

    private MoveFolderItemRequest(
        String itemId,
        String toFolderId
    ) {
        this.itemId = itemId;
        this.toFolderId = toFolderId;
    }

    @JsonProperty("item_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getItemId() {
        return itemId;
    }

    @JsonProperty("to_folder_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getToFolderId() {
        return toFolderId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof MoveFolderItemRequest && equalTo((MoveFolderItemRequest) other);
    }

    private boolean equalTo(MoveFolderItemRequest other) {
        return
            itemId.equals(other.itemId) &&

            toFolderId.equals(other.toFolderId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.itemId,
                   this.toFolderId
               );
    }

    @Override
    public String toString() {
        return "MoveFolderItemRequest{" +
               "itemId=" + itemId +
               "toFolderId=" + toFolderId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String itemId = null;
        private String toFolderId = null;

        private Builder() {}

        public Builder from(MoveFolderItemRequest other) {
            itemId(other.getItemId());
            toFolderId(other.getToFolderId());
            return this;
        }

        @JsonSetter("item_id")
        public Builder itemId(String itemId) {
            if (itemId == null) {
                throw new IllegalArgumentException("itemId cannot be null");
            }

            this.itemId = itemId;
            return this;
        }


        @JsonSetter("to_folder_id")
        public Builder toFolderId(String toFolderId) {
            if (toFolderId == null) {
                throw new IllegalArgumentException("toFolderId cannot be null");
            }

            this.toFolderId = toFolderId;
            return this;
        }



        public MoveFolderItemRequest build() {
            if (itemId == null) {
                throw new IllegalStateException("itemId is required");
            }

            if (toFolderId == null) {
                throw new IllegalStateException("toFolderId is required");
            }

            return new MoveFolderItemRequest(
                       itemId,
                       toFolderId
                   );
        }
    }

}




