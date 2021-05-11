package com.codesquad.baseball.utils;

import com.codesquad.baseball.domain.PlayType;

public class PitchRandomTable {

    private PitchRandomTable() {
    }

    private static PlayType[] PITCH_RANDOM_TABLE = {
            PlayType.STRIKE,
            PlayType.STRIKE,
            PlayType.BALL,
            PlayType.BALL,
            PlayType.BALL,
            PlayType.HOMERUN,
            PlayType.STRIKE,
            PlayType.STRIKE,
            PlayType.HITS,
            PlayType.HITS,
            PlayType.HITS,
            PlayType.HITS,
            PlayType.STRIKE,
            PlayType.STRIKE,
            PlayType.HOMERUN,
            PlayType.STRIKE,
            PlayType.STRIKE,
            PlayType.HITS,
            PlayType.STRIKE,
    };

    public static PlayType rollDice() {
        return PITCH_RANDOM_TABLE[(int)(Math.random() * PITCH_RANDOM_TABLE.length)];
    }
}
