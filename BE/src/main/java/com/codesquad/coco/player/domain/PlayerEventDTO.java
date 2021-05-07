package com.codesquad.coco.player.domain;

public class PlayerEventDTO {

    private RecordType record;

    public RecordType getRecord() {
        return record;
    }

    @Override
    public String toString() {
        return "PlayerEventDTO{" +
                "record=" + record +
                '}';
    }
}
