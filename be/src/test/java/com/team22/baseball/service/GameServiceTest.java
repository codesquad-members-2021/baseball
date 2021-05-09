package com.team22.baseball.service;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Player;
import com.team22.baseball.domain.Team;
import com.team22.baseball.repository.GameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GameServiceTest {

    @Autowired
    GameRepository gameRepository;


    @Test
    @DisplayName("Game 리스트 순회 테스트")
    void allGame() {
        Iterable<Game> games = gameRepository.findAll();

        for (Game game : games) {
            assertThat(game).isNotNull();
        }
    }

    @Test
    @DisplayName("첫번째 게임을 검색한다.")
    void findGameOfId() throws Exception {
        Game findGame = gameRepository.findById(1L).orElseThrow(Exception::new);
        assertThat(findGame).isNotNull();
    }

    @Test
    @DisplayName("두번째 게임에 속한 Team을 출력한다.")
    void team() throws Exception {
        Game findGame = gameRepository.findById(2L).orElseThrow(Exception::new);
        List<Team> teamList = findGame.getTeams();

        assertAll(
                () -> assertEquals(teamList.get(0).getName(), "Frontend1"),
                () -> assertTrue(teamList.get(0).isHome()),
                () -> assertEquals(teamList.get(1).getName(), "Frontend2"),
                () -> assertFalse(teamList.get(1).isHome())
        );
    }

    @Test
    @DisplayName("Backend2 팀의 선수가 10명인지 테스트")
    void printAllPlayer() {
        List<Game> games = gameRepository.findAll();
        String findTeam = "Backend2";

        for (Game game : games) {
            for (Team team : game.getTeams()) { //TODO. GameRepository에서 Team을 한번에 찾을 수 있는 Query작성하기
                if (team.getName().equals(findTeam)) {
                    System.out.println(team.getPlayers().toString());
                    assertThat(team.getPlayers().size()).isEqualTo(10);
                    break;
                }
            }
        }
    }


    @Test
    @DisplayName("Backend팀 선수의 초기 정보가 유효한지 검사한다.")
    void infoOfPlayer() {
        List<Game> games = gameRepository.findAll();
        String findTeam = "Backend";

        for (Game game : games) {
            for (Team team : game.getTeams()) { //TODO. GameRepository에서 Team을 한번에 찾을 수 있는 Query작성하기 또는 분리할 방법 생각하기
                if (team.getName().equals(findTeam)) {
                    for (Player player : team.getPlayers()) {
                        assertThat(player.getHits()).isZero();
                        assertThat(player.getOuts()).isZero();
                        assertThat(player.getPlateAppearance()).isZero();
                    }
                }

            }
        }
    }


    @Test
    @DisplayName("Backend1팀 선수의 히스토리 출력 테스트")
    void historyTest(){
        List<Game> games = gameRepository.findAll();
        String findTeam = "Backend1";

        for (Game game : games) {
            for (Team team : game.getTeams()) { //TODO. GameRepository에서 Team을 한번에 찾을 수 있는 Query작성하기 또는 분리할 방법 생각하기
                if (team.getName().equals(findTeam)) {
                    for (Player player : team.getPlayers()) {
                        System.err.println(player.getPlayerHistories().toString());
                    }
                }
            }
        }

    }


}
