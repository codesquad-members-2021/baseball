package com.codesquad.baseball.DTO.record;

import com.codesquad.baseball.domain.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PlayerRecordDTO {

    private static final int AVERAGE_DECIMAL_PLACES = 3;

    private Long id;

    private String name;

    private int plateAppearance;

    private int hit;

    private int out;

    private BigDecimal average;

    private int battingOrder;

    private int backNumber;

    private boolean isPitcher;

    public static PlayerRecordDTO of(Player player) {
        BigDecimal average = (player.getPlateAppearance() > 0) ?
                BigDecimal.valueOf(player.getHit() / (double) player.getPlateAppearance()) : BigDecimal.ZERO;
        average = average.setScale(AVERAGE_DECIMAL_PLACES, RoundingMode.CEILING);

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

    private PlayerRecordDTO(Long id, String name, int plateAppearance, int hit, int out, BigDecimal average,
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

    public BigDecimal getAverage() {
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
