package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class History {
    @Id
    private Integer id;
    private PlayType playType;
    private int strikeCount;
    private int ballCount;
    private int pitcher;
    private int hitter;

    public History(PlayType playType, int strikeCount, int ballCount, int pitcher, int hitter) {
        this.playType = playType;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.pitcher = pitcher;
        this.hitter = hitter;
    }

    public Integer getId() {
        return id;
    }

    public PlayType getPlayType() {
        return playType;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getPitcher() {
        return pitcher;
    }

    public int getHitter() {
        return hitter;
    }
}
