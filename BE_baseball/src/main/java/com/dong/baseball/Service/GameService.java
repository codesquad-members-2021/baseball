package com.dong.baseball.Service;

import com.dong.baseball.DTO.MatchDTO;
import com.dong.baseball.DTO.MatchUpListsDTO;
import com.dong.baseball.DTO.ProgressDTO;
import com.dong.baseball.DTO.BaseballServerResponseDTO;
import com.dong.baseball.Domain.Board;
import com.dong.baseball.Domain.Match;
import com.dong.baseball.Repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    //private final BoardRepository boardRepository;
    private final LeagueRepository leagueRepository;

    public GameService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public MatchUpListsDTO matchList() {
        List<Match> matchList = leagueRepository.findAll();
        List<MatchDTO> dtoList = new ArrayList<>();
        for (Match match : matchList) {
            dtoList.add(new MatchDTO(match));
        }
        return new MatchUpListsDTO(dtoList);
    }

    public List<ProgressDTO> matchInformations(Long matchId) {
        Match match = leagueRepository.findById(matchId).get();//@Todo get
        List<Board> matchBoards = match.getGameBoards();
        List<ProgressDTO> matchBoardInfo = new ArrayList<>();

        for (Board board : matchBoards) {
            matchBoardInfo.add(new ProgressDTO(board));
        }

        return matchBoardInfo;
    }

    public Board matchStream(Long matchId) {
        Match match = leagueRepository.findById(matchId).get();//@Todo get
        List<Board> matchBoards = match.getGameBoards();
        return matchBoards.get(matchBoards.size() - 1);
    }


    public BaseballServerResponseDTO gameStart(Long matchId) {
        System.out.println("start!");
        return new BaseballServerResponseDTO();
    }

    public BaseballServerResponseDTO gameEnd(Long matchId) {
        System.out.println("end");
        return new BaseballServerResponseDTO();
    }

    public BaseballServerResponseDTO gameProgress(Long matchId) {
        System.out.println("progress");
        return new BaseballServerResponseDTO();
    }
}

