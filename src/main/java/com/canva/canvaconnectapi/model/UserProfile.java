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
@JsonDeserialize(builder = UserProfile.Builder.class)
public final class UserProfile {
    /**
     * The name of the user as shown in the Canva UI.
     */
    private final Optional<String> displayName;

    private UserProfile(
        Optional<String> displayName
    ) {
        this.displayName = displayName;
    }

    @JsonProperty("display_name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDisplayName() {
        return displayName.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UserProfile && equalTo((UserProfile) other);
    }

    private boolean equalTo(UserProfile other) {
        return
            displayName.equals(other.displayName)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.displayName
               );
    }

    @Override
    public String toString() {
        return "UserProfile{" +
               "displayName=" + displayName +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> displayName = Optional.empty();

        private Builder() {}

        public Builder from(UserProfile other) {
            displayName(other.getDisplayName());
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


        public UserProfile build() {
            return new UserProfile(
                       displayName
                   );
        }
    }

}




