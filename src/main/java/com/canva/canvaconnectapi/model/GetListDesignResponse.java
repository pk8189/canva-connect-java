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
@JsonDeserialize(builder = GetListDesignResponse.Builder.class)
public final class GetListDesignResponse {
    /**
     * A continuation token.
     * If the success response contains a continuation token, the list contains more designs
     * you can list. You can use this token as a query parameter and retrieve more
     * designs from the list, for example
     * &#x60;/v1/designs?continuation&#x3D;{continuation}&#x60;.
     *
     * To retrieve all of a user&#x27;s designs, you might need to make multiple requests.
     */
    private final Optional<String> continuation;
    /**
     * The list of designs.
     */
    private final List<Design> items;

    private GetListDesignResponse(
        Optional<String> continuation,
        List<Design> items
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
    public List<Design> getItems() {
        return items;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof GetListDesignResponse && equalTo((GetListDesignResponse) other);
    }

    private boolean equalTo(GetListDesignResponse other) {
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
        return "GetListDesignResponse{" +
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
        private List<Design> items = null;

        private Builder() {}

        public Builder from(GetListDesignResponse other) {
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
        public Builder items(List<Design> items) {
            if (items == null) {
                throw new IllegalArgumentException("items cannot be null");
            }

            this.items = items;
            return this;
        }



        public GetListDesignResponse build() {
            if (items == null) {
                throw new IllegalStateException("items is required");
            }

            return new GetListDesignResponse(
                       continuation,
                       items
                   );
        }
    }

}




