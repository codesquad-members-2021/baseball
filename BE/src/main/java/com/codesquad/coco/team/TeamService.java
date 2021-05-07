package com.codesquad.coco.team;

import com.codesquad.coco.game.domain.DAO.GameDAO;
import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.player.domain.PlayerDAO;
import com.codesquad.coco.player.domain.UserType;
import com.codesquad.coco.team.domain.DTO.MainPageTeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamChoiceDTO;
import com.codesquad.coco.team.domain.Team;
import com.codesquad.coco.team.domain.TeamDAO;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamDAO teamDAO;
    private final GameDAO gameDAO;
    private final PlayerDAO playerDAO;

    public TeamService(TeamDAO teamDAO, GameDAO gameDAO, PlayerDAO playerDAO) {
        this.teamDAO = teamDAO;
        this.gameDAO = gameDAO;
        this.playerDAO = playerDAO;
    }

    public MainPageTeamDTO findMainTeams() {
        return teamDAO.findAllName();
    }

    public Long makeHomeGame(TeamChoiceDTO choiceDTO) {
        Team playerTeam = getPlayerTeam(choiceDTO);
        Team opponentTeam = getOpponentTeam(choiceDTO);

        Game game = new Game(opponentTeam, playerTeam, UserType.HOME);
        return gameDAO.save(game);
    }

    public Long makeAwayGame(TeamChoiceDTO choiceDTO) {
        Team playerTeam = getPlayerTeam(choiceDTO);
        Team opponentTeam = getOpponentTeam(choiceDTO);

        Game game = new Game(playerTeam, opponentTeam, UserType.AWAY);
        return gameDAO.save(game);
    }

    private Team getPlayerTeam(TeamChoiceDTO choiceDTO) {
        String teamName = choiceDTO.getUser();
        return new Team(teamName, playerDAO.findByTeamName(teamName));
    }

    private Team getOpponentTeam(TeamChoiceDTO choiceDTO) {
        String teamName = choiceDTO.getOpponent();
        return new Team(teamName, playerDAO.findByTeamName(teamName));
    }
}
