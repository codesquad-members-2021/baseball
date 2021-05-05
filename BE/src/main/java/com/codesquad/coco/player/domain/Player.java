package com.codesquad.coco.player.domain;

import org.springframework.data.annotation.Id;

public class Player {

    @Id
    private Long id;

    private String name;
    private String type;
    private Record record;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Record getRecord() {
        return record;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", record=" + record +
                '}';
    }
}
