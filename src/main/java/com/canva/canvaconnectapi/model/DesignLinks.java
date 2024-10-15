package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DesignLinks.Builder.class)
public final class DesignLinks {
    /**
     * A temporary editing URL for the design.
     *
     * NOTE: This is not a permanent URL, it is only valid for 30 days.
     */
    private final String editUrl;
    /**
     * A temporary viewing URL for the design.
     *
     * NOTE: This is not a permanent URL, it is only valid for 30 days.
     *
     */
    private final String viewUrl;

    private DesignLinks(
        String editUrl,
        String viewUrl
    ) {
        this.editUrl = editUrl;
        this.viewUrl = viewUrl;
    }

    @JsonProperty("edit_url")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getEditUrl() {
        return editUrl;
    }

    @JsonProperty("view_url")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getViewUrl() {
        return viewUrl;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DesignLinks && equalTo((DesignLinks) other);
    }

    private boolean equalTo(DesignLinks other) {
        return
            editUrl.equals(other.editUrl) &&

            viewUrl.equals(other.viewUrl)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.editUrl,
                   this.viewUrl
               );
    }

    @Override
    public String toString() {
        return "DesignLinks{" +
               "editUrl=" + editUrl +
               "viewUrl=" + viewUrl +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String editUrl = null;
        private String viewUrl = null;

        private Builder() {}

        public Builder from(DesignLinks other) {
            editUrl(other.getEditUrl());
            viewUrl(other.getViewUrl());
            return this;
        }

        @JsonSetter("edit_url")
        public Builder editUrl(String editUrl) {
            if (editUrl == null) {
                throw new IllegalArgumentException("editUrl cannot be null");
            }

            this.editUrl = editUrl;
            return this;
        }


        @JsonSetter("view_url")
        public Builder viewUrl(String viewUrl) {
            if (viewUrl == null) {
                throw new IllegalArgumentException("viewUrl cannot be null");
            }

            this.viewUrl = viewUrl;
            return this;
        }



        public DesignLinks build() {
            if (editUrl == null) {
                throw new IllegalStateException("editUrl is required");
            }

            if (viewUrl == null) {
                throw new IllegalStateException("viewUrl is required");
            }

            return new DesignLinks(
                       editUrl,
                       viewUrl
                   );
        }
    }

}




