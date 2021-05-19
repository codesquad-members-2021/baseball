package com.team22.baseball.dto.request;

public class SelectTeam {
    private String title;

    public SelectTeam(String title) {
        this.title = title;
    }

    public SelectTeam(){
        new SelectTeam("");
    }

    public String getTitle() {
        return title;
    }
}
