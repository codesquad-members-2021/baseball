package com.baseball.domain.match;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public enum PlayResult {
    BALL, HIT, STRIKE;

    private static final Random random = new Random();
    private static final List<PlayResult> pitches = Arrays.asList(values());

    private static PlayResult getRandomPitch() {
        return pitches.get(random.nextInt(pitches.size()));
    }

    public static PlayResult of(String name) {
        name = name.toUpperCase();
        return Optional.ofNullable(valueOf(name))
                .orElseGet(PlayResult::getRandomPitch);
    }

    public Boolean toBoolean() {
        return this == STRIKE;
    }
}
