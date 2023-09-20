package com.atguigu.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名:com.atguigu.result
 *
 * @author Leevi
 * 日期2023-09-03  10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private Boolean flag;
    private T data;

    public static <T> Result<T> ok(){
        return ok(null);
    }

    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setFlag(true);
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> error(){
        return error(null);
    }

    public static <T> Result<T> error(T data){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setFlag(false);
        if (data != null) {
            result.setData(data);
        }
        return result;
    }
}
