package com.baseball.dto;

import java.util.List;

public class PlayersDto {
    private List<PitcherDto> pitchers;
    private List<BatterDto> batters;

    public PlayersDto(List<PitcherDto> pitchers, List<BatterDto> batters) {
        this.pitchers = pitchers;
        this.batters = batters;
    }

    public List<PitcherDto> getPitchers() {
        return pitchers;
    }

    public void setPitchers(List<PitcherDto> pitchers) {
        this.pitchers = pitchers;
    }

    public List<BatterDto> getBatters() {
        return batters;
    }

    public void setBatters(List<BatterDto> batters) {
        this.batters = batters;
    }
}
