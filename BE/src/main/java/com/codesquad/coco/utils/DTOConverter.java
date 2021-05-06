package com.codesquad.coco.utils;

import com.codesquad.coco.player.domain.PlayerDTO;
import com.codesquad.coco.team.domain.DTO.TeamDTO;
import com.codesquad.coco.team.domain.Team;

import java.util.List;
import java.util.stream.Collectors;

public class DTOConverter {

    public static TeamDTO teamToDTO(Team team) {
        List<PlayerDTO> opponentPlayerDTO = team.getPlayers().stream()
                .map(player -> new PlayerDTO(player.getId(), player.getName(), player.getType()))
                .collect(Collectors.toList());
        return new TeamDTO(team.getName(), opponentPlayerDTO);
    }
}
