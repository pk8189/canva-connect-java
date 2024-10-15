package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UserProfileResponse.Builder.class)
public final class UserProfileResponse {
    private final UserProfile profile;

    private UserProfileResponse(
        UserProfile profile
    ) {
        this.profile = profile;
    }

    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public UserProfile getProfile() {
        return profile;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UserProfileResponse && equalTo((UserProfileResponse) other);
    }

    private boolean equalTo(UserProfileResponse other) {
        return
            profile.equals(other.profile)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.profile
               );
    }

    @Override
    public String toString() {
        return "UserProfileResponse{" +
               "profile=" + profile +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private UserProfile profile = null;

        private Builder() {}

        public Builder from(UserProfileResponse other) {
            profile(other.getProfile());
            return this;
        }

        @JsonSetter("profile")
        public Builder profile(UserProfile profile) {
            if (profile == null) {
                throw new IllegalArgumentException("profile cannot be null");
            }

            this.profile = profile;
            return this;
        }



        public UserProfileResponse build() {
            if (profile == null) {
                throw new IllegalStateException("profile is required");
            }

            return new UserProfileResponse(
                       profile
                   );
        }
    }

}




