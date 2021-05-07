package com.dong.baseball.DTO;

import com.dong.baseball.Domain.Player;

import java.util.List;

public class ProgressDTO {

    private String away;
    private String home;
    private int inning;
    private String offenseTurn;
    private List<Player> firstBase;
    private List<Player> secondBase;
    private List<Player> thirdBase;
    private Player pitcher;
    private Player batter;

}
