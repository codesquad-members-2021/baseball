package com.codesquad.coco.player.domain.DTO;

public class PlayerDTO {

    private Long id;
    private String name;
    private String type;
    private int atBat;
    private int hits;
    private int out;
    private double average;

    public PlayerDTO(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public PlayerDTO(Long id, String name, String type, int atBat, int hits, int out, double average) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.atBat = atBat;
        this.hits = hits;
        this.out = out;
        this.average = average;
    }

    public int getAtBat() {
        return atBat;
    }

    public int getHits() {
        return hits;
    }

    public int getOut() {
        return out;
    }

    public double getAverage() {
        return average;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
