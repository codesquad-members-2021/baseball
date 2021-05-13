package com.baseball.dto;

public class ProgressRequestDto {
    String result;

    protected ProgressRequestDto() {}

    public ProgressRequestDto(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
