package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class Player {

    @Id
    private Long id;

    private String name;

    private int hit;

    private int out;

    private int plateAppearance;

    private int battingOrder;

    private int backNumber;

    private boolean isPitcher;

    public Player(String name, int battingOrder, int backNumber, boolean isPitcher) {
        this.name = name;
        this.battingOrder = battingOrder;
        this.backNumber = backNumber;
        this.isPitcher = isPitcher;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHit() {
        return hit;
    }

    public int getOut() {
        return out;
    }

    public int getPlateAppearance() {
        return plateAppearance;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public void setPlateAppearance(int plateAppearance) {
        this.plateAppearance = plateAppearance;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    public void setBackNumber(int backNumber) {
        this.backNumber = backNumber;
    }

    public void setPitcher(boolean pitcher) {
        isPitcher = pitcher;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
