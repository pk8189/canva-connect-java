package com.canva.canvaconnectapi.resources.v1.brandtemplates.params;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.canva.canvaconnectapi.model.DatasetFilterEnum;
import com.canva.canvaconnectapi.model.OwnershipTypeEnum;
import com.canva.canvaconnectapi.model.SortByTypeEnum;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListRequest.Builder.class)
public final class ListRequest {
    private final Optional<String> continuation;
    private final Optional<DatasetFilterEnum> dataset;
    private final Optional<OwnershipTypeEnum> ownership;
    private final Optional<String> query;
    private final Optional<SortByTypeEnum> sortBy;

    private ListRequest(
        Optional<String> continuation,
        Optional<DatasetFilterEnum> dataset,
        Optional<OwnershipTypeEnum> ownership,
        Optional<String> query,
        Optional<SortByTypeEnum> sortBy
    ) {
        this.continuation = continuation;
        this.dataset = dataset;
        this.ownership = ownership;
        this.query = query;
        this.sortBy = sortBy;
    }

    @JsonProperty("continuation")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getContinuation() {
        return continuation.orElse(null);
    }

    @JsonProperty("dataset")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DatasetFilterEnum getDataset() {
        return dataset.orElse(null);
    }

    @JsonProperty("ownership")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public OwnershipTypeEnum getOwnership() {
        return ownership.orElse(null);
    }

    @JsonProperty("query")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getQuery() {
        return query.orElse(null);
    }

    @JsonProperty("sortBy")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public SortByTypeEnum getSortBy() {
        return sortBy.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ListRequest && equalTo((ListRequest) other);
    }

    private boolean equalTo(ListRequest other) {
        return
            continuation.equals(other.continuation) &&

            dataset.equals(other.dataset) &&

            ownership.equals(other.ownership) &&

            query.equals(other.query) &&

            sortBy.equals(other.sortBy)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.continuation,
                   this.dataset,
                   this.ownership,
                   this.query,
                   this.sortBy
               );
    }

    @Override
    public String toString() {
        return "ListRequest{" +
               "continuation=" + continuation +
               "dataset=" + dataset +
               "ownership=" + ownership +
               "query=" + query +
               "sortBy=" + sortBy +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> continuation = Optional.empty();
        private Optional<DatasetFilterEnum> dataset = Optional.empty();
        private Optional<OwnershipTypeEnum> ownership = Optional.empty();
        private Optional<String> query = Optional.empty();
        private Optional<SortByTypeEnum> sortBy = Optional.empty();

        private Builder() {}

        public Builder from(ListRequest other) {
            continuation(other.getContinuation());
            dataset(other.getDataset());
            ownership(other.getOwnership());
            query(other.getQuery());
            sortBy(other.getSortBy());
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

        @JsonSetter("dataset")
        public Builder dataset(DatasetFilterEnum dataset) {
            this.dataset = Optional.ofNullable(dataset);
            return this;
        }

        public Builder dataset(Optional<DatasetFilterEnum> dataset) {
            this.dataset = dataset;
            return this;
        }

        @JsonSetter("ownership")
        public Builder ownership(OwnershipTypeEnum ownership) {
            this.ownership = Optional.ofNullable(ownership);
            return this;
        }

        public Builder ownership(Optional<OwnershipTypeEnum> ownership) {
            this.ownership = ownership;
            return this;
        }

        @JsonSetter("query")
        public Builder query(String query) {
            this.query = Optional.ofNullable(query);
            return this;
        }

        public Builder query(Optional<String> query) {
            this.query = query;
            return this;
        }

        @JsonSetter("sortBy")
        public Builder sortBy(SortByTypeEnum sortBy) {
            this.sortBy = Optional.ofNullable(sortBy);
            return this;
        }

        public Builder sortBy(Optional<SortByTypeEnum> sortBy) {
            this.sortBy = sortBy;
            return this;
        }


        public ListRequest build() {
            return new ListRequest(
                       continuation,
                       dataset,
                       ownership,
                       query,
                       sortBy
                   );
        }
    }

}




