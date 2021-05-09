package com.baseball.dto;


import com.baseball.domain.match.Match;

public class InningInfoDto {
    private final Integer inningCount;
    private final Boolean isUserTop;
    private final Boolean isUserOffense;

    private InningInfoDto(Builder buider) {
        this.inningCount = buider.inningCount;
        this.isUserTop = buider.isUserTop;
        this.isUserOffense = buider.isUserOffense;

    }

    private static class Builder {
        private Integer inningCount;
        private Boolean isUserTop;
        private Boolean isUserOffense;

        private Builder inningCount(Integer inningCount) {
            this.inningCount = inningCount;
            return this;
        }

        private Builder userTop(Boolean userTop) {
            isUserTop = userTop;
            return this;
        }

        private Builder userOffense(Boolean userOffense) {
            isUserOffense = userOffense;
            return this;
        }

        private InningInfoDto build() {
            return new InningInfoDto(this);
        }
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

    public static InningInfoDto from(Match match) {
        Builder builder = new Builder()
                .inningCount(match.getInningCount())
                .userTop(match.getUserTop())
                .userOffense(match.getUserOffense());
        return builder.build();
    }
}
