package com.openadmin.common.core;

import java.time.LocalDateTime;

public class ApiResult<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiResult() {}
    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> ApiResult<T> ok() { return new ApiResult<>(200, "操作成功", null); }
    public static <T> ApiResult<T> ok(T data) { return new ApiResult<>(200, "操作成功", data); }
    public static <T> ApiResult<T> fail(String message) { return new ApiResult<>(500, message, null); }
    public static <T> ApiResult<T> fail(int code, String message) { return new ApiResult<>(code, message, null); }
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
