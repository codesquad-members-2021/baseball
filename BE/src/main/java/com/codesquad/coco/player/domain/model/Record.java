package com.codesquad.coco.player.domain.model;

import com.codesquad.coco.player.domain.RecordType;
import org.springframework.data.annotation.Id;

public class Record {

    @Id
    private Long id;

    private int atBat;
    private int hits;
    private int outs;

    public Record(Long id, int atBat, int hits, int outs) {
        this.id = id;
        this.atBat = atBat;
        this.hits = hits;
        this.outs = outs;
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
        return (double) hits / atBat;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", atBat=" + atBat +
                ", hits=" + hits +
                ", outs=" + outs +
                ", average=" + getAverage() +
                '}';
    }

    public void update(RecordType log) {
        this.atBat++;
        if (log == RecordType.HITS) {
            this.hits++;
        }
        if (log == RecordType.OUT) {
            this.outs++;
        }
    }
}
