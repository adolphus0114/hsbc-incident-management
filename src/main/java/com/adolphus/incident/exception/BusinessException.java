package com.adolphus.incident.exception;

import java.text.MessageFormat;

/**
 * Exception for Business definition
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public class BusinessException extends RuntimeException {
    private int code;
    private String message;

    public static BusinessException build(BusinessError error, Object ... args){
        if(args != null && args.length != 0){
            return new BusinessException(error.code(), MessageFormat.format(error.message(), args));
        }else{
            return new BusinessException(error.code(), error.message());
        }
    }

    public static BusinessException build(Throwable cause, BusinessError error, Object ... args){
        if(args != null && args.length != 0){
            return new BusinessException(error.code(), MessageFormat.format(error.message(), args), cause);
        }else{
            return new BusinessException(error.code(), error.message(), cause);
        }
    }

    private BusinessException(int code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    private BusinessException(int code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
