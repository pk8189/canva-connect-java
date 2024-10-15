package com.canva.canvaconnectapi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateDesignAutofillJobRequestData.Builder.class)
public final class CreateDesignAutofillJobRequestData {
    private final Map<String, DatasetValue> additionalProperties;

    private CreateDesignAutofillJobRequestData(

        Map<String, DatasetValue> additionalProperties
    ) {
        this.additionalProperties = additionalProperties;
    }

    @JsonAnyGetter
    public Map<String, DatasetValue> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof CreateDesignAutofillJobRequestData &&
               equalTo((CreateDesignAutofillJobRequestData) other);
    }

    private boolean equalTo(CreateDesignAutofillJobRequestData other) {
        return
            additionalProperties.equals(other.additionalProperties)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(

                   this.additionalProperties
               );
    }

    @Override
    public String toString() {
        return "CreateDesignAutofillJobRequestData{" +
               ", additionalProperties=" + additionalProperties +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<String, DatasetValue> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateDesignAutofillJobRequestData other) {
            additionalProperties(other.getAdditionalProperties());
            return this;
        }

        @JsonAnySetter
        public Builder additionalProperty(String key, DatasetValue value) {
            this.additionalProperties.put(key, value);
            return this;
        }

        public Builder additionalProperties(Map<String, DatasetValue> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        public CreateDesignAutofillJobRequestData build() {
            return new CreateDesignAutofillJobRequestData(

                       additionalProperties
                   );
        }
    }

}




