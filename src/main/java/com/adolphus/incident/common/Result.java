package com.adolphus.incident.common;
/**
 * Common result for controller
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public class Result<T> {
    
    private static final int SUCCESS = 0;
    private static final int FAILED = 1;

    private int code;
    private String message;
    private T data;

    /**
     * success result
     * @return
     */
    public static Result<Void> success(){
        Result<Void> result = new Result<>();
        result.setCode(SUCCESS);
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result<Void> fail(String message){
        Result<Void> result = new Result<>();
        result.setCode(FAILED);
        result.setMessage(message);
        return result;
    }

    public static Result<Void> fail(int code, String message){
        Result<Void> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
