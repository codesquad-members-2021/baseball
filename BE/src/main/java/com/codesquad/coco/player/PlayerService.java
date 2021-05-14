package com.codesquad.coco.player;

import com.codesquad.coco.player.domain.PlayerDAO;
import com.codesquad.coco.player.domain.model.DTO.PlayerEventDTO;
import com.codesquad.coco.player.domain.model.Player;
import com.codesquad.coco.player.domain.model.Record;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }


    public Player findById(Long playerId) {
        return playerDAO.findById(playerId);
    }

    public void updateRecord(Record record, PlayerEventDTO eventDTO) {
        record.update(eventDTO.getRecord());
        playerDAO.updateRecord(record);
    }
}
