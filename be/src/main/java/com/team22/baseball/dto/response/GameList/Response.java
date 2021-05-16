package com.team22.baseball.dto.response.GameList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response<T> {

    @JsonProperty("game_list")
    private List<T> data;

    public Response(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }
}
