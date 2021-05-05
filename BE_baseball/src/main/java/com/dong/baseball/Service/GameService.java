package com.dong.baseball.Service;

import com.dong.baseball.DTO.MatchUpListDTO;
import com.dong.baseball.DTO.SituationBoardDTO;
import com.dong.baseball.Domain.Board;
import com.dong.baseball.Domain.Match;
import com.dong.baseball.Repository.BoardRepository;
import com.dong.baseball.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final BoardRepository boardRepository;
    private final LeagueRepository leagueRepository;

    public GameService(BoardRepository boardRepository, LeagueRepository leagueRepository) {
        this.boardRepository = boardRepository;
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

    public List<SituationBoardDTO> matchInformations() {
        List<Board> matchBoards = leagueRepository.
    }
}

