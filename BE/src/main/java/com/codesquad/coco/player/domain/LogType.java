package com.codesquad.coco.player.domain;

public enum LogType {
    HITS("안타"),
    OUT("아웃");

    private String log;

    LogType(String log) {
        this.log = log;
    }
}
