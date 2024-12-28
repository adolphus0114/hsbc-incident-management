package com.adolphus.incident.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adolphus.incident.common.Result;

/**
 * global exception handler
 * 
 * @auther Zhang Chi
 * @date 2024-12-27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler
    public Result<Void> errorHandler(Exception exception){
        logger.error("GlobalExceptionHandler log",exception);
        if(exception instanceof BusinessException){
            BusinessException businessException = (BusinessException)exception;
            return Result.fail(businessException.getCode(), businessException.getMessage());
        }else{
            return Result.fail(BusinessError.UNKNOWN_ERROR.code(), BusinessError.UNKNOWN_ERROR.message());
        }
    }
}
