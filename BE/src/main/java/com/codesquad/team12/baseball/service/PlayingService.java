package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.model.Player;
import com.codesquad.team12.baseball.model.Playing;
import com.codesquad.team12.baseball.model.Team;
import com.codesquad.team12.baseball.repository.PlayingRepository;
import com.codesquad.team12.baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PlayingService {
    private final PlayingRepository playingRepository;
    private final TeamRepository teamRepository;

    public PlayingService(PlayingRepository playingRepository, TeamRepository teamRepository) {
        this.playingRepository = playingRepository;
        this.teamRepository = teamRepository;
    }

    public void initPlaying(Long gameId, String teamName) {
        Team team = teamRepository.findById(teamName).orElseThrow(IllegalArgumentException::new);
        Map<Long, Player> players = team.getPlayers();

        for (Player player : players.values()) {
            Playing playing = new Playing(team.getName(), player.getNumber(), player.getName(), player.getPosition(), gameId);
            playingRepository.save(playing);
        }

    }
}
