package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UsersMeResponse.Builder.class)
public final class UsersMeResponse {
    private final TeamUserSummary teamUser;

    private UsersMeResponse(
        TeamUserSummary teamUser
    ) {
        this.teamUser = teamUser;
    }

    @JsonProperty("team_user")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public TeamUserSummary getTeamUser() {
        return teamUser;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof UsersMeResponse && equalTo((UsersMeResponse) other);
    }

    private boolean equalTo(UsersMeResponse other) {
        return
            teamUser.equals(other.teamUser)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.teamUser
               );
    }

    @Override
    public String toString() {
        return "UsersMeResponse{" +
               "teamUser=" + teamUser +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private TeamUserSummary teamUser = null;

        private Builder() {}

        public Builder from(UsersMeResponse other) {
            teamUser(other.getTeamUser());
            return this;
        }

        @JsonSetter("team_user")
        public Builder teamUser(TeamUserSummary teamUser) {
            if (teamUser == null) {
                throw new IllegalArgumentException("teamUser cannot be null");
            }

            this.teamUser = teamUser;
            return this;
        }



        public UsersMeResponse build() {
            if (teamUser == null) {
                throw new IllegalStateException("teamUser is required");
            }

            return new UsersMeResponse(
                       teamUser
                   );
        }
    }

}




