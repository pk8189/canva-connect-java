package com.canva.canvaconnectapi.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListFolderItemsResponse.Builder.class)
public final class ListFolderItemsResponse {
    /**
     * If the success response contains a continuation token, the folder contains more items
     * you can list. You can use this token as a query parameter and retrieve more
     * items from the list, for example
     * &#x60;/v1/folders/{folderId}/items?continuation&#x3D;{continuation}&#x60;.
     *
     * To retrieve all the items in a folder, you might need to make multiple requests.
     */
    private final Optional<String> continuation;
    /**
     * An array of items in the folder.
     */
    private final List<FolderItemSummary> items;

    private ListFolderItemsResponse(
        Optional<String> continuation,
        List<FolderItemSummary> items
    ) {
        this.continuation = continuation;
        this.items = items;
    }

    @JsonProperty("continuation")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getContinuation() {
        return continuation.orElse(null);
    }

    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<FolderItemSummary> getItems() {
        return items;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ListFolderItemsResponse && equalTo((ListFolderItemsResponse) other);
    }

    private boolean equalTo(ListFolderItemsResponse other) {
        return
            continuation.equals(other.continuation) &&

            items.equals(other.items)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.continuation,
                   this.items
               );
    }

    @Override
    public String toString() {
        return "ListFolderItemsResponse{" +
               "continuation=" + continuation +
               "items=" + items +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> continuation = Optional.empty();
        private List<FolderItemSummary> items = null;

        private Builder() {}

        public Builder from(ListFolderItemsResponse other) {
            continuation(other.getContinuation());
            items(other.getItems());
            return this;
        }

        @JsonSetter("continuation")
        public Builder continuation(String continuation) {
            this.continuation = Optional.ofNullable(continuation);
            return this;
        }

        public Builder continuation(Optional<String> continuation) {
            this.continuation = continuation;
            return this;
        }

        @JsonSetter("items")
        public Builder items(List<FolderItemSummary> items) {
            if (items == null) {
                throw new IllegalArgumentException("items cannot be null");
            }

            this.items = items;
            return this;
        }



        public ListFolderItemsResponse build() {
            if (items == null) {
                throw new IllegalStateException("items is required");
            }

            return new ListFolderItemsResponse(
                       continuation,
                       items
                   );
        }
    }

}




