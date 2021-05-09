package com.baseball.domain;

public class InningInfo {

    private final Integer inningCount;
    private final Boolean isUserTop;
    private final Boolean isUserOffense;

    public InningInfo(Integer inningCount, Boolean isUserTop, Boolean isUserOffense) {
        this.inningCount = inningCount;
        this.isUserTop = isUserTop;
        this.isUserOffense = isUserOffense;
    }

    public Integer getInningCount() {
        return inningCount;
    }

    public Boolean getUserTop() {
        return isUserTop;
    }

    public Boolean getUserOffense() {
        return isUserOffense;
    }
}
