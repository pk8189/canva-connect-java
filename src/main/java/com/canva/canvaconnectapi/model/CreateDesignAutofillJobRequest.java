package com.canva.canvaconnectapi.model;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateDesignAutofillJobRequest.Builder.class)
public final class CreateDesignAutofillJobRequest {
    /**
     * ID of the input brand template.
     */
    private final String brandTemplateId;
    /**
     * Data object containing the data fields and values to autofill.
     */
    private final CreateDesignAutofillJobRequestData data;
    /**
     * Title to use for the autofilled design. Must be less than 256 characters.
     *
     * If no design title is provided, the autofilled design will have the same title as the brand template.
     */
    private final Optional<String> title;

    private CreateDesignAutofillJobRequest(
        String brandTemplateId,
        CreateDesignAutofillJobRequestData data,
        Optional<String> title
    ) {
        this.brandTemplateId = brandTemplateId;
        this.data = data;
        this.title = title;
    }

    @JsonProperty("brand_template_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getBrandTemplateId() {
        return brandTemplateId;
    }

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public CreateDesignAutofillJobRequestData getData() {
        return data;
    }

    @JsonProperty("title")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTitle() {
        return title.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateDesignAutofillJobRequest &&
               equalTo((CreateDesignAutofillJobRequest) other);
    }

    private boolean equalTo(CreateDesignAutofillJobRequest other) {
        return
            brandTemplateId.equals(other.brandTemplateId) &&

            data.equals(other.data) &&

            title.equals(other.title)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.brandTemplateId,
                   this.data,
                   this.title
               );
    }

    @Override
    public String toString() {
        return "CreateDesignAutofillJobRequest{" +
               "brandTemplateId=" + brandTemplateId +
               "data=" + data +
               "title=" + title +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String brandTemplateId = null;
        private CreateDesignAutofillJobRequestData data = null;
        private Optional<String> title = Optional.empty();

        private Builder() {}

        public Builder from(CreateDesignAutofillJobRequest other) {
            brandTemplateId(other.getBrandTemplateId());
            data(other.getData());
            title(other.getTitle());
            return this;
        }

        @JsonSetter("brand_template_id")
        public Builder brandTemplateId(String brandTemplateId) {
            if (brandTemplateId == null) {
                throw new IllegalArgumentException("brandTemplateId cannot be null");
            }

            this.brandTemplateId = brandTemplateId;
            return this;
        }


        @JsonSetter("data")
        public Builder data(CreateDesignAutofillJobRequestData data) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }

            this.data = data;
            return this;
        }


        @JsonSetter("title")
        public Builder title(String title) {
            this.title = Optional.ofNullable(title);
            return this;
        }

        public Builder title(Optional<String> title) {
            this.title = title;
            return this;
        }


        public CreateDesignAutofillJobRequest build() {
            if (brandTemplateId == null) {
                throw new IllegalStateException("brandTemplateId is required");
            }

            if (data == null) {
                throw new IllegalStateException("data is required");
            }

            return new CreateDesignAutofillJobRequest(
                       brandTemplateId,
                       data,
                       title
                   );
        }
    }

}




