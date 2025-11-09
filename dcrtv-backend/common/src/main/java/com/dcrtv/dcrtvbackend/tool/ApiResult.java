package com.dcrtv.dcrtvbackend.tool;


public class ApiResult<T> {
    private boolean result;
    private String message;
    private T data;

    public ApiResult(boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static ApiResult success(String message){
        return new ApiResult(true,message,null);
    }

    public static <T> ApiResult<T> success(String message,T data){
        return new ApiResult<T>(true,message,data);
    }

    public static ApiResult error(String message){
        return new ApiResult(false,message,null);
    }

    public static <T> ApiResult<T> error(String message,T data){
        return new ApiResult<T>(false,message,data);
    }
}


