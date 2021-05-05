package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class BaseballGameTeamInformationMap {

    @MappedCollection()
    private final Map<TeamEnum, BaseballGameTeamInformation> teamInformationMap;

    BaseballGameTeamInformationMap(Map<TeamEnum, BaseballGameTeamInformation> teamInformationMap) {
        this.teamInformationMap = teamInformationMap;
    }

    public Map<TeamEnum, BaseballGameTeamInformation> getTeamInformationMap() {
        return teamInformationMap;
    }

    public static BaseballGameTeamInformationMap newTeamInformation(Team home, Team away) {
        Map<TeamEnum, BaseballGameTeamInformation> teamInformationMap = new HashMap<>();
        teamInformationMap.put(TeamEnum.HOME, BaseballGameTeamInformation.newTeamInfo(home));
        teamInformationMap.put(TeamEnum.AWAY, BaseballGameTeamInformation.newTeamInfo(away));
        return new BaseballGameTeamInformationMap(teamInformationMap);
    }
}
