package com.swf.simple.user.handler;

import com.swf.simple.user.exception.BusinessException;
import com.swf.simple.user.utils.ResponseVoUtil;
import com.swf.simple.user.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author SWF
 * @Date 2019/6/5 16:36
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResponseVO handlerBusinessException(BusinessException e){
        return ResponseVoUtil.fail(e.getCode(),e.getMessage());
    }
}
