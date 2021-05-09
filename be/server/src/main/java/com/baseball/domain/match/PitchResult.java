package com.baseball.domain.match;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public enum PitchResult {
    BALL, HIT, STRIKE;

    private static final Random random = new Random();
    private static final List<PitchResult> pitches = Arrays.asList(values());

    private static PitchResult getRandomPitch() {
        return pitches.get(random.nextInt(pitches.size()));
    }

    public static PitchResult of(String name) {
        name = name.toUpperCase();
        return Optional.ofNullable(valueOf(name))
                .orElseGet(PitchResult::getRandomPitch);
    }

    public Boolean toBoolean() {
        return this == STRIKE;
    }
}
