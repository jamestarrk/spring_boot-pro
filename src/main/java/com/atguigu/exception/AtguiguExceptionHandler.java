package com.atguigu.exception;

import com.atguigu.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 包名:com.atguigu.exception
 *
 * @author Leevi
 * 日期2023-09-11  14:28
 */
@RestControllerAdvice
@Slf4j
public class AtguiguExceptionHandler {
    /**
     * 处理普通异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        //日志记录异常信息
        log.error("出现异常:{}",e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理数据校验异常
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleBindException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            log.error("数据校验出现异常:{}",fieldError.getDefaultMessage());
        });

        return Result.error(bindingResult.getFieldErrors().get(0).getDefaultMessage());
    }
}
