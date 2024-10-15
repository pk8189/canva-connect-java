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
@JsonDeserialize(builder = User.Builder.class)
public final class User {
    /**
     * The name of the user as shown in the Canva UI.
     */
    private final Optional<String> displayName;
    /**
     * The ID of the user.
     */
    private final String id;

    private User(
        Optional<String> displayName,
        String id
    ) {
        this.displayName = displayName;
        this.id = id;
    }

    @JsonProperty("display_name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDisplayName() {
        return displayName.orElse(null);
    }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getId() {
        return id;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof User && equalTo((User) other);
    }

    private boolean equalTo(User other) {
        return
            displayName.equals(other.displayName) &&

            id.equals(other.id)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.displayName,
                   this.id
               );
    }

    @Override
    public String toString() {
        return "User{" +
               "displayName=" + displayName +
               "id=" + id +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> displayName = Optional.empty();
        private String id = null;

        private Builder() {}

        public Builder from(User other) {
            displayName(other.getDisplayName());
            id(other.getId());
            return this;
        }

        @JsonSetter("display_name")
        public Builder displayName(String displayName) {
            this.displayName = Optional.ofNullable(displayName);
            return this;
        }

        public Builder displayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        @JsonSetter("id")
        public Builder id(String id) {
            if (id == null) {
                throw new IllegalArgumentException("id cannot be null");
            }

            this.id = id;
            return this;
        }



        public User build() {
            if (id == null) {
                throw new IllegalStateException("id is required");
            }

            return new User(
                       displayName,
                       id
                   );
        }
    }

}




