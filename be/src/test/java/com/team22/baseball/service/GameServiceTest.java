package com.team22.baseball.service;

import com.team22.baseball.domain.Game;
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
    @DisplayName("Id로 게임을 검색한다.")
    void findGameOfId() throws Exception {
        Game findGame = gameRepository.findById(1L).orElseThrow(Exception::new);
        assertThat(findGame).isNotNull();
    }

    @Test
    @DisplayName("Game2에 속한 Team을 출력한다.")
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

}
