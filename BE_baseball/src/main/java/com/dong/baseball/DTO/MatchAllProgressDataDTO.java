package com.dong.baseball.DTO;

import java.util.List;

public class MatchAllProgressDataDTO {
    private MatchDTO matchInfomation;
    private List<ProgressDTO> progressInfoList;

    public MatchAllProgressDataDTO(MatchDTO matchInfomation, List<ProgressDTO> progressInfoList) {
        this.matchInfomation = matchInfomation;
        this.progressInfoList = progressInfoList;
    }

    public MatchDTO getMatchInfomation() {
        return matchInfomation;
    }

    public void setMatchInfomation(MatchDTO matchInfomation) {
        this.matchInfomation = matchInfomation;
    }

    public List<ProgressDTO> getProgressInfoList() {
        return progressInfoList;
    }

    public void setProgressInfoList(List<ProgressDTO> progressInfoList) {
        this.progressInfoList = progressInfoList;
    }


}
