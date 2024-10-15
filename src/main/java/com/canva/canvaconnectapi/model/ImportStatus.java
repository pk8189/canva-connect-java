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
@JsonDeserialize(builder = ImportStatus.Builder.class)
public final class ImportStatus {
    private final Optional<ImportError> error;
    private final ImportStatusStateEnum state;

    private ImportStatus(
        Optional<ImportError> error,
        ImportStatusStateEnum state
    ) {
        this.error = error;
        this.state = state;
    }

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ImportError getError() {
        return error.orElse(null);
    }

    @JsonProperty("state")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public ImportStatusStateEnum getState() {
        return state;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof ImportStatus && equalTo((ImportStatus) other);
    }

    private boolean equalTo(ImportStatus other) {
        return
            error.equals(other.error) &&

            state.equals(other.state)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.error,
                   this.state
               );
    }

    @Override
    public String toString() {
        return "ImportStatus{" +
               "error=" + error +
               "state=" + state +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<ImportError> error = Optional.empty();
        private ImportStatusStateEnum state = null;

        private Builder() {}

        public Builder from(ImportStatus other) {
            error(other.getError());
            state(other.getState());
            return this;
        }

        @JsonSetter("error")
        public Builder error(ImportError error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        public Builder error(Optional<ImportError> error) {
            this.error = error;
            return this;
        }

        @JsonSetter("state")
        public Builder state(ImportStatusStateEnum state) {
            if (state == null) {
                throw new IllegalArgumentException("state cannot be null");
            }

            this.state = state;
            return this;
        }



        public ImportStatus build() {
            if (state == null) {
                throw new IllegalStateException("state is required");
            }

            return new ImportStatus(
                       error,
                       state
                   );
        }
    }

}




