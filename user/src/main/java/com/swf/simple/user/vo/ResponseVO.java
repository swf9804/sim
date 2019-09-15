package com.swf.simple.user.vo;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * <pre>
 * http请求返回的最外层对象
 * </pre>
 */
@Data
public class ResponseVO<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private T data;
  private Integer code;
  private Integer httpStatus;
  private String path;
  private Long timestamp;
  private String message;

  /**
   * @param httpStatus HTTP状态码
   * @param code 业务代码
   * @param request request对象
   * @return 响应体
   */
  public static <E> ResponseVO<E> build(Integer httpStatus, Integer code, HttpServletRequest request) {
    return build(httpStatus, code, null, null, request);
  }

  /**
   * @param httpStatus HTTP代码
   * @param code 业务代码
   * @param data 随错误响应体返回的相关错误数据。
   * @param request request对象
   * @return 响应体
   */
  public static <E> ResponseVO<E> build(Integer httpStatus, Integer code, E data, HttpServletRequest request) {
    return build(httpStatus, code, null, data, request);
  }

  /**
   * @param httpStatus HTTP代码
   * @param code 业务代码
   * @param exception 异常对象
   * @param request request对象
   * @return 响应体
   */
  public static <E> ResponseVO<E> build(Integer httpStatus, Integer code, Exception exception,
                                        HttpServletRequest request) {
    return build(httpStatus, code, exception, null, request);
  }

  /**
   * <p>
   * 创建响应体。
   * 
   * @param httpStatus HTTP状态码
   * @param code 业务代码
   * @param data 伴随错误响应体一起返回的相关数据
   * @param exception 发生的异常信息
   * @param request request对象
   * @return 响应体
   */
  public static <E> ResponseVO<E> build(Integer httpStatus, Integer code, Exception exception, E data,
                                        HttpServletRequest request) {
    ResponseVO<E> response = new ResponseVO<E>();
    response.data = data;
    if (null != exception) {
      response.message = exception.getClass().getCanonicalName();
    }
    if (null != request) {
      response.path = request.getRequestURI();
    }
    response.httpStatus = httpStatus;
    response.code = code;
    response.timestamp = System.currentTimeMillis();
    return response;
  }
  
  public boolean isSuccess(){
  	return this.code==0;
  }

}
