package com.dong.baseball.Service;

import com.dong.baseball.DTO.MatchUpListDTO;
import com.dong.baseball.Domain.Match;
import com.dong.baseball.Repository.GameRepository;
import com.dong.baseball.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final LeagueRepository leagueRepository;

    public GameService(GameRepository gameRepository, LeagueRepository leagueRepository) {
        this.gameRepository = gameRepository;
        this.leagueRepository = leagueRepository;
    }


    public List<MatchUpListDTO> matchList() {
        List<Match> matchList =  leagueRepository.findAll();
        List<MatchUpListDTO> dtoList = new ArrayList<>();
        for(Match match : matchList) {
            dtoList.add(new MatchUpListDTO(match));
        }
        return dtoList;
    }
}

