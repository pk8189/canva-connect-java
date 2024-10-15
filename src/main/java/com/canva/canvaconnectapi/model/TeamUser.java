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
@JsonDeserialize(builder = TeamUser.Builder.class)
public final class TeamUser {
    /**
     * The name of the user as shown in the Canva UI.
     */
    private final Optional<String> displayName;
    /**
     * The ID of the user&#x27;s Canva Team.
     */
    private final Optional<String> teamId;
    /**
     * The ID of the user.
     */
    private final Optional<String> userId;

    private TeamUser(
        Optional<String> displayName,
        Optional<String> teamId,
        Optional<String> userId
    ) {
        this.displayName = displayName;
        this.teamId = teamId;
        this.userId = userId;
    }

    @JsonProperty("display_name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getDisplayName() {
        return displayName.orElse(null);
    }

    @JsonProperty("team_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTeamId() {
        return teamId.orElse(null);
    }

    @JsonProperty("user_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUserId() {
        return userId.orElse(null);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TeamUser && equalTo((TeamUser) other);
    }

    private boolean equalTo(TeamUser other) {
        return
            displayName.equals(other.displayName) &&

            teamId.equals(other.teamId) &&

            userId.equals(other.userId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.displayName,
                   this.teamId,
                   this.userId
               );
    }

    @Override
    public String toString() {
        return "TeamUser{" +
               "displayName=" + displayName +
               "teamId=" + teamId +
               "userId=" + userId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> displayName = Optional.empty();
        private Optional<String> teamId = Optional.empty();
        private Optional<String> userId = Optional.empty();

        private Builder() {}

        public Builder from(TeamUser other) {
            displayName(other.getDisplayName());
            teamId(other.getTeamId());
            userId(other.getUserId());
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

        @JsonSetter("team_id")
        public Builder teamId(String teamId) {
            this.teamId = Optional.ofNullable(teamId);
            return this;
        }

        public Builder teamId(Optional<String> teamId) {
            this.teamId = teamId;
            return this;
        }

        @JsonSetter("user_id")
        public Builder userId(String userId) {
            this.userId = Optional.ofNullable(userId);
            return this;
        }

        public Builder userId(Optional<String> userId) {
            this.userId = userId;
            return this;
        }


        public TeamUser build() {
            return new TeamUser(
                       displayName,
                       teamId,
                       userId
                   );
        }
    }

}




