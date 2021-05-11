package com.codesquad.baseball.DTO.record.request;

public class PlayerRecordRequest {

    private Long playerId;

    private int plateAppearance;

    private int hit;

    private int out;

    public Long getPlayerId() {
        return playerId;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }

    public int getHit() {
        return hit;
    }

    public int getOut() {
        return out;
    }
}
