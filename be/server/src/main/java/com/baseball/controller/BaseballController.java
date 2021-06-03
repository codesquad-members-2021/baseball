package com.baseball.controller;

import com.baseball.dto.*;
import com.baseball.service.BaseballService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Baseball API"}, description = "야구 게임과 관련된 API")
@RestController
@RequestMapping("/api")
public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    @GetMapping("/match")
    @ApiOperation(value = "참가가능 게임 목록 조회", notes = "참가할 수 있는 야구 게임 목록을 조회합니다.")
    public ResponseEntity<List<MatchDto>> getMatch() {
        List<MatchDto> matches = baseballService.getMatches();
        return ResponseEntity.ok().body(matches);
    }

    @GetMapping("/progress/{id}")
    @ApiOperation(value = "야구 진행 조회", notes = "야구의 진행 상황에 관한 정보를 조회합니다.")
    public ResponseEntity<MatchInfoDto> getProgress(@ApiParam("게임의 식별자") @PathVariable String id) {
        MatchInfoDto matchInfo = baseballService.getProgress(id);
        return ResponseEntity.ok().body(matchInfo);
    }

    @GetMapping("/gameInfo/{id}")
    @ApiOperation(value = "야구 이닝 정보 조회", notes = "야구의 이닝을 나타내는 상세 정보를 조회합니다.")
    public ResponseEntity<GameInfoDto> getGameInfo(@ApiParam("게임의 식별자") @PathVariable String id) {
        GameInfoDto gameInfo = baseballService.getGameInfo(id);
        return ResponseEntity.ok().body(gameInfo);
    }

    @PostMapping("/match")
    @ApiOperation(value = "게임 입장 요청", notes = "게임에 입장하면서 응원할 팀을 선택합니다.")
    public ResponseEntity<Void> selectTeam(@RequestBody MatchRequestDto matchRequestDto) {
        String matchId = matchRequestDto.getId();
        String teamName = matchRequestDto.getSelectedTeam();
        baseballService.selectTeam(matchId, teamName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/progress/{id}")
    @ApiOperation(value = "게임 진행", notes = "게임을 진행합니다. hit, strike, ball 을 입력할 수 있습니다.")
    public ResponseEntity<MatchInfoDto> progressGame(@ApiParam("게임의 식별자") @PathVariable String id, @RequestBody ProgressRequestDto progressRequestDto) {
        String result = progressRequestDto.getResult();
        baseballService.playGame(id, result);
        MatchInfoDto matchInfo = baseballService.getProgress(id);
        return ResponseEntity.ok().body(matchInfo);
    }
}
