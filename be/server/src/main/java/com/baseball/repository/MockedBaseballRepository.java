package com.baseball.repository;

import com.baseball.domain.Match;
import com.baseball.domain.Matches;
import com.baseball.domain.Team;
import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;

import java.util.Arrays;
import java.util.Map;

public class MockedBaseballRepository implements BaseballRepository {
    private final Matches matches = new Matches();

    @Override
    public Map<String, Match> findAllMatches() {
        return matches.getMatches();
    }

    @Override
    public Match findMatchById(String id) {
        return matches.getMatch(id);
    }

    public MockedBaseballRepository() {
        matches.put("U924AX", new Match(
                new Team("Captain", new Players(
                        Arrays.asList(new Pitcher("캡틴1투수"), new Pitcher("캡틴2투수")),
                        Arrays.asList(new Batter("캡틴1타자"), new Batter("캡틴2타자"))
                )),
                new Team("Marble", new Players(
                        Arrays.asList(new Pitcher("마블1투수"), new Pitcher("마블2투수")),
                        Arrays.asList(new Batter("마블1타자"), new Batter("마블2타자"))
                ))
        ));
        matches.put("H132UY", new Match(
                new Team("Honux", new Players(
                        Arrays.asList(new Pitcher("호눅스1투수"), new Pitcher("호눅스2투수")),
                        Arrays.asList(new Batter("호눅스1타자"), new Batter("호눅스2타자"))
                )),
                new Team("Crong", new Players(
                        Arrays.asList(new Pitcher("크롱1투수"), new Pitcher("크롱2투수")),
                        Arrays.asList(new Batter("크롱1타자"), new Batter("크롱2타자"))
                ))
        ));
        matches.put("M887UW", new Match(
                new Team("Android", new Players(
                        Arrays.asList(new Pitcher("안드로이드1투수"), new Pitcher("안드로이드2투수")),
                        Arrays.asList(new Batter("안드로이드1타자"), new Batter("안드로이드2타자"))
                )),
                new Team("Apple", new Players(
                        Arrays.asList(new Pitcher("애플1투수"), new Pitcher("애플2투수")),
                        Arrays.asList(new Batter("애플1타자"), new Batter("애플2타자"))
                ))
        ));
    }
}
