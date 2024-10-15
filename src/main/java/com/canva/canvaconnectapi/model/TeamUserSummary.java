package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TeamUserSummary.Builder.class)
public final class TeamUserSummary {
    /**
     * The ID of the user&#x27;s Canva Team.
     */
    private final String teamId;
    /**
     * The ID of the user.
     */
    private final String userId;

    private TeamUserSummary(
        String teamId,
        String userId
    ) {
        this.teamId = teamId;
        this.userId = userId;
    }

    @JsonProperty("team_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("user_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public String getUserId() {
        return userId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof TeamUserSummary && equalTo((TeamUserSummary) other);
    }

    private boolean equalTo(TeamUserSummary other) {
        return
            teamId.equals(other.teamId) &&

            userId.equals(other.userId)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.teamId,
                   this.userId
               );
    }

    @Override
    public String toString() {
        return "TeamUserSummary{" +
               "teamId=" + teamId +
               "userId=" + userId +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String teamId = null;
        private String userId = null;

        private Builder() {}

        public Builder from(TeamUserSummary other) {
            teamId(other.getTeamId());
            userId(other.getUserId());
            return this;
        }

        @JsonSetter("team_id")
        public Builder teamId(String teamId) {
            if (teamId == null) {
                throw new IllegalArgumentException("teamId cannot be null");
            }

            this.teamId = teamId;
            return this;
        }


        @JsonSetter("user_id")
        public Builder userId(String userId) {
            if (userId == null) {
                throw new IllegalArgumentException("userId cannot be null");
            }

            this.userId = userId;
            return this;
        }



        public TeamUserSummary build() {
            if (teamId == null) {
                throw new IllegalStateException("teamId is required");
            }

            if (userId == null) {
                throw new IllegalStateException("userId is required");
            }

            return new TeamUserSummary(
                       teamId,
                       userId
                   );
        }
    }

}




