package com.team22.baseball.dto.response.TeamSelect;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamInfoDto {

    @JsonProperty("team_name")
    private String name;

    @JsonProperty("selected")
    private boolean selected;

    @JsonIgnore // 왜인지는 모르겠지만 boolean 형식의 자료형은 Json필드가 하다 더 생김...
    private boolean isHome;

    public TeamInfoDto(String name, boolean selected, boolean isHome) {
        this.name = name;
        this.selected = selected;
        this.isHome = isHome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    @Override
    public String toString() {
        return "TeamInfoDto{" +
                "name='" + name + '\'' +
                ", selected=" + selected +
                ", isHome=" + isHome +
                '}';
    }
}
