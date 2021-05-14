package com.dong.baseball.DTO;

public class BaseballServerResponseDTO {
    private int code;
    private String status;
    private String explanation;

    public BaseballServerResponseDTO() {
        this.code = 200;
        this.status = "OK";
        this.explanation = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
