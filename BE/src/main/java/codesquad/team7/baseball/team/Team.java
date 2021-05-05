package codesquad.team7.baseball.team;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    @Id
    @Column("team_id")
    private final Long id;

    @Column("team_name")
    private final String name;

    private final Integer pitcherNumber;

    @MappedCollection(idColumn = "team_id", keyColumn = "team_players_index")
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

    public void addPlayers(Player... players) {
        this.players.addAll(Arrays.asList(players));
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
