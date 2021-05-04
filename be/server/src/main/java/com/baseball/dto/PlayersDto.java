package com.baseball.dto;

import java.util.List;

public class PlayersDto {
    private final List<PitcherDto> pitchers;
    private final List<BatterDto> batters;

    public PlayersDto(List<PitcherDto> pitchers, List<BatterDto> batters) {
        this.pitchers = pitchers;
        this.batters = batters;
    }

    public List<PitcherDto> getPitchers() {
        return pitchers;
    }

    public List<BatterDto> getBatters() {
        return batters;
    }
}
