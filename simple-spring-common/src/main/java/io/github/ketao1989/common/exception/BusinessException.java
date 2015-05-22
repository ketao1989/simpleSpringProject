package io.github.ketao1989.common.exception;

/**
 * 自定义业务异常
 *
 * @author: tao.ke Date: 15-5-22 Time: 上午11:46
 * @version: \$Id$
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3310746132109189365L;

    public BusinessException(){

    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
