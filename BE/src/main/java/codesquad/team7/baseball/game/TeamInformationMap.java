package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class TeamInformationMap {

    @MappedCollection(idColumn = "game_id", keyColumn = "baseball_game_team")
    private final Map<TeamEnum, BaseballGameTeamInformation> teamInformationMap;

    TeamInformationMap(Map<TeamEnum, BaseballGameTeamInformation> teamInformationMap) {
        this.teamInformationMap = teamInformationMap;
    }

    public Map<TeamEnum, BaseballGameTeamInformation> getTeamInformationMap() {
        return teamInformationMap;
    }

    public static TeamInformationMap newTeamInformation(Team home, Team away) {
        Map<TeamEnum, BaseballGameTeamInformation> teamInformationMap = new HashMap<>();
        teamInformationMap.put(TeamEnum.HOME, BaseballGameTeamInformation.newTeamInfo(home));
        teamInformationMap.put(TeamEnum.AWAY, BaseballGameTeamInformation.newTeamInfo(away));
        return new TeamInformationMap(teamInformationMap);
    }
}
