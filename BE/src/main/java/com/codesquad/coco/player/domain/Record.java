package com.codesquad.coco.player.domain;

import org.springframework.data.annotation.Id;

public class Record {

    @Id
    private Long id;

    private int atBat;
    private int hits;
    private int outs;
    private double average;

    public Record(Long id, int atBat, int hits, int outs, double average) {
        this.id = id;
        this.atBat = atBat;
        this.hits = hits;
        this.outs = outs;
        this.average = average;
    }

    public Long getId() {
        return id;
    }

    public int getAtBat() {
        return atBat;
    }

    public int getHits() {
        return hits;
    }

    public int getOuts() {
        return outs;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", atBat=" + atBat +
                ", hits=" + hits +
                ", outs=" + outs +
                ", average=" + average +
                '}';
    }

    public void update(String log) {
        this.atBat++;
        if (log.equals("안타")) {
            this.hits++;
        }
        if (log.equals("아웃")) {
            this.outs++;
        }
        this.average = (double) hits / atBat;
    }
}
