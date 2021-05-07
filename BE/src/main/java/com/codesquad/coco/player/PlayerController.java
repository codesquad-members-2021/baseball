package com.codesquad.coco.player;

import com.codesquad.coco.player.domain.DTO.PlayerEventDTO;
import com.codesquad.coco.player.domain.Player;
import com.codesquad.coco.player.domain.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PutMapping("/players/{playerId}/record")
    @ResponseStatus(HttpStatus.OK)
    public void playerEvent(@PathVariable Long playerId, @RequestBody PlayerEventDTO eventDTO) {
        Player player = playerService.findById(playerId);
        Record record = player.getRecord();
        playerService.updateRecord(record, eventDTO);
    }
}
