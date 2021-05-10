package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class TeamInformationMap {

    @MappedCollection(idColumn = "game_id", keyColumn = "baseball_game_team")
    private final Map<String, BaseballGameTeamInformation> teamInformationMap;

    TeamInformationMap(Map<String, BaseballGameTeamInformation> teamInformationMap) {
        this.teamInformationMap = teamInformationMap;
    }

    public static TeamInformationMap newTeamInformation(Team home, Team away) {
        Map<String, BaseballGameTeamInformation> teamInformationMap = new HashMap<>();

        teamInformationMap.put(TeamEnum.HOME.name(), BaseballGameTeamInformation.newTeamInfo(home));

        BaseballGameTeamInformation awayTeamInfo = BaseballGameTeamInformation.newTeamInfo(away);
        awayTeamInfo.nextInning();

        teamInformationMap.put(TeamEnum.AWAY.name(), awayTeamInfo);
        return new TeamInformationMap(teamInformationMap);
    }

    public BaseballGameTeamInformation getHome() {
        return teamInformationMap.get(TeamEnum.HOME.name());
    }

    public BaseballGameTeamInformation getAway() {
        return teamInformationMap.get(TeamEnum.AWAY.name());
    }

    public Integer getBatter(TeamEnum teamEnum) {
        BaseballGameTeamInformation teamInformation = teamInformationMap.get(teamEnum.name());
        return teamInformation.getBatter();
    }

    public void hit(TeamEnum attackTeam) {
        BaseballGameTeamInformation attackTeamInformation = teamInformationMap.get(attackTeam.name());
        attackTeamInformation.hit();
    }

    public void pitch(TeamEnum defenceTeam) {
        BaseballGameTeamInformation defenceTeamInformation = teamInformationMap.get(defenceTeam.name());
        defenceTeamInformation.pitch();
    }

    public void scoreUp(TeamEnum attackTeam, int currentInning) {
        BaseballGameTeamInformation attackTeamInformation = teamInformationMap.get(attackTeam.name());
        attackTeamInformation.scoreUp(currentInning);
    }

    public void setNextBatter(TeamEnum attackTeam) {
        BaseballGameTeamInformation attackTeamInformation = teamInformationMap.get(attackTeam.name());
        attackTeamInformation.setNextBatter();
    }

    public void out(TeamEnum attackTeam) {
        BaseballGameTeamInformation attackTeamInformation = teamInformationMap.get(attackTeam.name());
        attackTeamInformation.out();
    }

    public void nextInning(TeamEnum team) {
        BaseballGameTeamInformation teamInformation = teamInformationMap.get(team.name());
        teamInformation.nextInning();
    }

    public Long getTeamId(TeamEnum team) {
        BaseballGameTeamInformation teamInformation = teamInformationMap.get(team.name());
        return teamInformation.getTeamId();
    }

    public String getTeamName(TeamEnum team) {
        BaseballGameTeamInformation teamInformation = teamInformationMap.get(team.name());
        return teamInformation.getTeamName();
    }
}
