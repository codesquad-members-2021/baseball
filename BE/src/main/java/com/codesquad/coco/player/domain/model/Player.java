package com.codesquad.coco.player.domain.model;

import org.springframework.data.annotation.Id;

public class Player {

    @Id
    private Long id;

    private String name;
    private String type;
    private Record record;

    public Player(Long id, String name, String type, Record record) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.record = record;
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
