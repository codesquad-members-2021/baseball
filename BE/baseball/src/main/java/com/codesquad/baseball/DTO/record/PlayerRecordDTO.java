package com.codesquad.baseball.DTO.record;

import com.codesquad.baseball.domain.Player;

import java.text.DecimalFormat;

public class PlayerRecordDTO {

    private static final DecimalFormat AVERAGE_FORMAT = new DecimalFormat("#.###");
    private Long id;

    private String name;

    private int plateAppearance;

    private int hit;

    private int out;

    private String average;

    private int battingOrder;

    private int backNumber;

    private boolean isPitcher;

    public static PlayerRecordDTO of(Player player) {
        String average = "0";
        if (player.getPlateAppearance() > 0) {
            average = AVERAGE_FORMAT.format(player.getHit() / (float) player.getPlateAppearance());
        }
        return new PlayerRecordDTO(
                player.getId(),
                player.getName(),
                player.getPlateAppearance(),
                player.getHit(),
                player.getOut(),
                average,
                player.getBattingOrder(),
                player.getBackNumber(),
                player.isPitcher()
        );
    }

    private PlayerRecordDTO(Long id, String name, int plateAppearance, int hit, int out, String average,
                            int battingOrder, int backNumber, boolean isPitcher) {
        this.id = id;
        this.name = name;
        this.plateAppearance = plateAppearance;
        this.hit = hit;
        this.out = out;
        this.average = average;
        this.backNumber = backNumber;
        this.battingOrder = battingOrder;
        this.isPitcher = isPitcher;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }

    public int getHit() {
        return hit;
    }

    public int getOut() {
        return out;
    }

    public String getAverage() {
        return average;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public int getBackNumber() {
        return backNumber;
    }

    public boolean isPitcher() {
        return isPitcher;
    }
}
