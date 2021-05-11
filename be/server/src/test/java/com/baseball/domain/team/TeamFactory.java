package com.baseball.domain.team;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TeamFactory {
    private static List<Pitcher> createPitchers(String teamName, int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(i -> new Pitcher(String.format("%s%d투수", teamName, i)))
                .collect(Collectors.toList());
    }

    private static List<Batter> createBatters(String teamName, int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(i -> new Batter(String.format("%s%d타자", teamName, i)))
                .collect(Collectors.toList());
    }

    static Team createTeam(String teamName) {
        return new Team(teamName, new Players(
                createPitchers(teamName, 5),
                createBatters(teamName, 9)
        ));
    }
}
