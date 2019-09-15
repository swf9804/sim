package com.swf.simple.user.utils;

import com.swf.simple.user.enums.Errors;
import com.swf.simple.user.exception.BusinessException;
import com.swf.simple.user.vo.ResponseVO;
import org.springframework.http.HttpStatus;

/**
 * 响应返回数据工具类
 *
 * @author jzsong@uworks.cc
 */
public class ResponseVoUtil {

    public static <T> ResponseVO<T> success(T data) {
        ResponseVO<T> entity = new ResponseVO<T>();
        entity.setData(data);
        entity.setCode(Errors.SUCCESS.getCode());
        entity.setHttpStatus(HttpStatus.OK.value());
        entity.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        return entity;
    }

    public static <T> ResponseVO<T> success() {
        return success(null);
    }

    public static <T> ResponseVO<T> fail(Integer code, String message) {
        ResponseVO<T> entity = new ResponseVO<T>();
        entity.setHttpStatus(HttpStatus.OK.value());
        entity.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        entity.setCode(code);
        entity.setMessage(message);
        return entity;
    }

    public static <T> ResponseVO<T> fail(Errors errors) {
        ResponseVO<T> entity = new ResponseVO<T>();
        entity.setHttpStatus(HttpStatus.OK.value());
        entity.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        entity.setCode(errors.getCode());
        entity.setMessage(errors.getMessage());
        return entity;
    }

    public static <T> ResponseVO<T> addMessage(int num) {
        if(0 == num){
            throw new BusinessException(Errors.SYSTEM_INSERT_FAIL.getMessage());
        }else{
            return ResponseVoUtil.success();
        }

    }

    public static <T> ResponseVO<T> message(T data) {
        return data == null ?
                ResponseVoUtil.fail(Errors.SYSTEM_DATA_NOT_FOUND) :
                ResponseVoUtil.success(data);
    }

    public static <T> ResponseVO<T> updMessage(int num) {
        if(0 == num){
            throw new BusinessException(Errors.SYSTEM_UPDATE_ERROR.getMessage());
        }else{
            return ResponseVoUtil.success();
        }
    }

    public static <T> ResponseVO<T> delMessage(int num) {
        if(0 == num){
            throw new BusinessException(Errors.SYSTEM_DELETE_FAIL.getMessage());
        }else{
            return ResponseVoUtil.success();
        }
    }
}
