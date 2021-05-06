package com.baseball.dto;

import com.baseball.domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersDto {
    private final List<PitcherDto> pitchers;
    private final List<BatterDto> batters;

    private PlayersDto(Builder builder) {
        this.pitchers = builder.pitchers;
        this.batters = builder.batters;
    }

    private static class Builder {
        private List<PitcherDto> pitchers;
        private List<BatterDto> batters;

        private Builder pitchers(List<PitcherDto> pitchers) {
            this.pitchers = pitchers;
            return this;
        }

        private Builder batters(List<BatterDto> batters) {
            this.batters = batters;
            return this;
        }

        private PlayersDto build() {
            return new PlayersDto(this);
        }
    }

    public List<PitcherDto> getPitchers() {
        return pitchers;
    }

    public List<BatterDto> getBatters() {
        return batters;
    }

    public static PlayersDto from(Players players) {
        Builder builder = new Builder()
                .pitchers(players.getPitchers().stream().map(PitcherDto::from).collect(Collectors.toList()))
                .batters(players.getBatters().stream().map(BatterDto::from).collect(Collectors.toList()));
        return builder.build();

    }
}
