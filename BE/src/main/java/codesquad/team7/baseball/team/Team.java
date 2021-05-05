package codesquad.team7.baseball.team;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class Team {

    @Id
    @Column("TEAM_ID")
    private final Long id;

    @Column("TEAM_NAME")
    private final String name;

    private final Integer pitcherNumber;

    @MappedCollection(idColumn = "TEAM_ID", keyColumn = "TEAM_PLAYERS_INDEX")
    private final List<Player> players;

    Team(Long id, String name, List<Player> players, Integer pitcherNumber) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.pitcherNumber = pitcherNumber;
    }

    public static Team newTeam(String name, Integer pitcherNumber) {
        return new Team(null, name, new ArrayList<>(), pitcherNumber);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPitcherNumber() {
        return pitcherNumber;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
