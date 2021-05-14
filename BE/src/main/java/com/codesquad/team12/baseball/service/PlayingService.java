package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.dto.response.PlayingDto;
import com.codesquad.team12.baseball.dto.request.PlayingRequestDto;
import com.codesquad.team12.baseball.model.Player;
import com.codesquad.team12.baseball.model.Playing;
import com.codesquad.team12.baseball.model.Team;
import com.codesquad.team12.baseball.repository.PlayingRepository;
import com.codesquad.team12.baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Player> playerList = new ArrayList<>(players.values());
        playerList.sort(Comparator.comparingInt(Player::getNumber));

        for (Player player : playerList) {
            Playing playing = new Playing(team.getName(), player.getNumber(), player.getName(), player.getPosition(), gameId);
            if (findByTeam(gameId, teamName, player.getNumber()) == null) {
                playingRepository.save(playing);
            }
        }
    }

    public List<PlayingDto> findAllByTeam(Long gameId, String teamName) {
        return playingRepository
                .findAllByTeam(gameId, teamName)
                .stream()
                .sorted(Comparator.comparing(Playing::getPlayerNumber))
                .map(Playing::createPlayingDto)
                .collect(Collectors.toList());
    }

    public void updatePlaying(Long gameId, PlayingRequestDto playingRequestDto) {
        playingRepository.updatePlaying(gameId, playingRequestDto.getTeamName(), playingRequestDto.getPlayerNumber(), playingRequestDto.getPa(), playingRequestDto.getHit(), playingRequestDto.getOut());
    }

    private Playing findByTeam(Long gameId, String teamName, Integer playerNumber) {
        return playingRepository.findByTeam(gameId, teamName, playerNumber);
    }

}
