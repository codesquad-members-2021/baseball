package com.codesquad.coco.player.domain;

public enum RecordType {
    HITS("hits"),
    OUT("out");

    private String log;

    RecordType(String log) {
        this.log = log;
    }
}
