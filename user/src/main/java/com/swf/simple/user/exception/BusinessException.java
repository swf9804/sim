package com.swf.simple.user.exception;
import com.swf.simple.user.enums.Errors;
import lombok.Data;


/**
 * <pre>
 * @Author swf
 * 业务异常，处理业务抛出的异常
 * 错误码和错误码说明，需要指定
 * </pre>
 */
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -4310721413425427596L;
    /**
     * 错误码
     */
    private int code = Errors.SYSTEM_ERROR.getCode();
    /**
     * 错误码的说明
     */
    private String message = Errors.SYSTEM_ERROR.getMessage();

    public BusinessException() {
        super();
    }

    /**
     * 构造自定义错误
     * @param message：错误码说明
     */
    public BusinessException(String message) {
        super(message);
        setCode(Errors.SYSTEM_CUSTOM_ERROR.getCode());
        setMessage(message);
    }

    /**
     * 构造函数
     * @param code：错误码
     * @param message：错误码说明
     */
    public BusinessException(int code, String message) {
        super(message);
        setCode(code);
        setMessage(message);
    }

    /**
     * 构造函数
     * @param error：错误枚举
     */
    public BusinessException(Errors error) {
        super(error.getMessage());
        setCode(error.getCode());
        setMessage(error.getMessage());
    }

    /**
     * 构造函数
     * @param error：错误枚举
     * @param cause
     */
    public BusinessException(Errors error, Throwable cause) {
        super(error.getMessage(), cause);
        setCode(error.getCode());
        setMessage(error.getMessage());
    }


}
