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
@JsonDeserialize(builder = ListBrandTemplatesResponse.Builder.class)
public final class ListBrandTemplatesResponse {
    /**
     * If the success response contains a continuation token, the user has access to more
     * brand templates you can list. You can use this token as a query parameter and retrieve
     * more templates from the list, for example
     * &#x60;/v1/brand-templates?continuation&#x3D;{continuation}&#x60;.
     * To retrieve all the brand templates available to the user, you might need to make
     * multiple requests.
     */
    private final Optional<String> continuation;
    /**
     * The list of brand templates.
     */
    private final List<BrandTemplate> items;

    private ListBrandTemplatesResponse(
        Optional<String> continuation,
        List<BrandTemplate> items
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
    public List<BrandTemplate> getItems() {
        return items;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ListBrandTemplatesResponse && equalTo((ListBrandTemplatesResponse) other);
    }

    private boolean equalTo(ListBrandTemplatesResponse other) {
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
        return "ListBrandTemplatesResponse{" +
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
        private List<BrandTemplate> items = null;

        private Builder() {}

        public Builder from(ListBrandTemplatesResponse other) {
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
        public Builder items(List<BrandTemplate> items) {
            if (items == null) {
                throw new IllegalArgumentException("items cannot be null");
            }

            this.items = items;
            return this;
        }



        public ListBrandTemplatesResponse build() {
            if (items == null) {
                throw new IllegalStateException("items is required");
            }

            return new ListBrandTemplatesResponse(
                       continuation,
                       items
                   );
        }
    }

}




