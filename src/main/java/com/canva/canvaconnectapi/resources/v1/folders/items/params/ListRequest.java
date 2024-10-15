package com.canva.canvaconnectapi.resources.v1.folders.items.params;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.FolderItemSortByEnum;
import com.canva.canvaconnectapi.model.FolderItemTypeEnum1;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListRequest.Builder.class)
public final class ListRequest {
    private final String folderId;
    private final Optional<String> continuation;
    private final Optional<List<FolderItemTypeEnum1>> itemTypes;
    private final Optional<FolderItemSortByEnum> sortBy;

    private ListRequest(
        String folderId,
        Optional<String> continuation,
        Optional<List<FolderItemTypeEnum1>> itemTypes,
        Optional<FolderItemSortByEnum> sortBy
    ) {
        this.folderId = folderId;
        this.continuation = continuation;
        this.itemTypes = itemTypes;
        this.sortBy = sortBy;
    }

    @JsonProperty("folderId")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getFolderId() {
        return folderId;
    }

    @JsonProperty("continuation")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getContinuation() {
        return continuation.orElse(null);
    }

    @JsonProperty("itemTypes")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<FolderItemTypeEnum1> getItemTypes() {
        return itemTypes.orElse(null);
    }

    @JsonProperty("sortBy")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public FolderItemSortByEnum getSortBy() {
        return sortBy.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ListRequest && equalTo((ListRequest) other);
    }

    private boolean equalTo(ListRequest other) {
        return
            folderId.equals(other.folderId) &&

            continuation.equals(other.continuation) &&

            itemTypes.equals(other.itemTypes) &&

            sortBy.equals(other.sortBy)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.folderId,
                   this.continuation,
                   this.itemTypes,
                   this.sortBy
               );
    }

    @Override
    public String toString() {
        return "ListRequest{" +
               "folderId=" + folderId +
               "continuation=" + continuation +
               "itemTypes=" + itemTypes +
               "sortBy=" + sortBy +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String folderId = null;
        private Optional<String> continuation = Optional.empty();
        private Optional<List<FolderItemTypeEnum1>> itemTypes = Optional.empty();
        private Optional<FolderItemSortByEnum> sortBy = Optional.empty();

        private Builder() {}

        public Builder from(ListRequest other) {
            folderId(other.getFolderId());
            continuation(other.getContinuation());
            itemTypes(other.getItemTypes());
            sortBy(other.getSortBy());
            return this;
        }

        @JsonSetter("folderId")
        public Builder folderId(String folderId) {
            if (folderId == null) {
                throw new IllegalArgumentException("folderId cannot be null");
            }

            this.folderId = folderId;
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

        @JsonSetter("itemTypes")
        public Builder itemTypes(List<FolderItemTypeEnum1> itemTypes) {
            this.itemTypes = Optional.ofNullable(itemTypes);
            return this;
        }

        public Builder itemTypes(Optional<List<FolderItemTypeEnum1>> itemTypes) {
            this.itemTypes = itemTypes;
            return this;
        }

        @JsonSetter("sortBy")
        public Builder sortBy(FolderItemSortByEnum sortBy) {
            this.sortBy = Optional.ofNullable(sortBy);
            return this;
        }

        public Builder sortBy(Optional<FolderItemSortByEnum> sortBy) {
            this.sortBy = sortBy;
            return this;
        }


        public ListRequest build() {
            if (folderId == null) {
                throw new IllegalStateException("folderId is required");
            }

            return new ListRequest(
                       folderId,
                       continuation,
                       itemTypes,
                       sortBy
                   );
        }
    }

}




