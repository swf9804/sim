package com.swf.simple.user.utils;

import com.springboot.framework.enums.Errors;
import com.springboot.framework.exception.BusinessException;

/**
 * 异常工具类
 *
 * @author jzsong@uworks.cc
 */
public class ExceptionUtil {

  public static void throwException(int code, String codeLabel) {
    BusinessException e = new BusinessException(code, codeLabel);
    throw e;
  }

  public static void throwException(Errors error) {
    BusinessException e = new BusinessException(error);
    throw e;
  }


}
