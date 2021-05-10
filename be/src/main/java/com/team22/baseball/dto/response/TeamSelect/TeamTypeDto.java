package com.team22.baseball.dto.response.TeamSelect;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamTypeDto {

    @JsonProperty("team_title")
    private String name;

    public TeamTypeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
