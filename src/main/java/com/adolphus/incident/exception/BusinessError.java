package com.adolphus.incident.exception;

/**
 * Business error enums
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
public enum BusinessError {
    UNKNOWN_ERROR(999999, "System error, please contact the system administrator."),
    SYSTEM_ERROR(999998, "System error, please contact the system administrator."),
    ID_NOT_EXISTS(1, "id {0} is not exists.");


    private int code;
    private String message;

    private BusinessError(int code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * get error code
     * @return
     */
    public int code(){
        return code;
    }

    /**
     * get error message
     * @return
     */
    public String message(){
        return message;
    }
}
