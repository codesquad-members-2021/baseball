package com.dong.baseball.DTO;

import java.util.List;

public class MatchUpListsDTO {
    List<MatchDTO> matchUpList;

    public MatchUpListsDTO(List<MatchDTO> matchUpList) {
        this.matchUpList = matchUpList;
    }

    public List<MatchDTO> getMatchUpList() {
        return matchUpList;
    }

    public void setMatchUpList(List<MatchDTO> matchUpList) {
        this.matchUpList = matchUpList;
    }
}
