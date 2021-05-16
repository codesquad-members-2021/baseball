package team9.baseball.DTO.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResult<T> {
    private T data;
    private String error;

    private ApiResult(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public static ApiResult<?> ok() {
        return new ApiResult<>("OK", null);
    }

    public static <T> ApiResult<T> succeed(T data) {
        return new ApiResult(data, null);
    }

    public static ApiResult<?> failed(String errorMessage) {
        return new ApiResult<>(null, errorMessage);
    }

    public static ApiResult<?> failed(Throwable throwable) {
        return failed(throwable.getMessage());
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
