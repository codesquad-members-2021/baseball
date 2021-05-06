package com.team22.baseball.service;

import com.team22.baseball.domain.Game;
import com.team22.baseball.repository.GameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class GameServiceTest {

    @Autowired
    GameRepository gameRepository;

    @Test
    @DisplayName("Game 생성 테스트")
    void createOfGame() {
        Game game = Game.of(10,false);
        assertThat(gameRepository.save(game).getRound()).isEqualTo(10);
    }

    @Test
    @DisplayName("Game 리스트 순회 테스트")
    void allGame() {
        Iterable<Game> games = gameRepository.findAll();

        for(Game game : games){
            assertThat(game).isNotNull();
        }
    }

    @Test
    @DisplayName("Id로 게임을 검색한다.")
    void findGameOfId() throws Exception {
        Game findGame = gameRepository.findById(1L).orElseThrow(Exception::new);
        assertThat(findGame).isNotNull();
    }


}
