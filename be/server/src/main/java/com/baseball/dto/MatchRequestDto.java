package com.baseball.dto;

public class MatchRequestDto {
    private String id;
    private String selectedTeam;

    protected MatchRequestDto() {}

    public MatchRequestDto(String id, String selectedTeam) {
        this.id = id;
        this.selectedTeam = selectedTeam;
    }

    public String getId() {
        return id;
    }

    public String getSelectedTeam() {
        return selectedTeam;
    }
}
