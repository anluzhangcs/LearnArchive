package exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/19-15:57
 */

import org.junit.Test;

/**
 * @Description 为负数的异常
 */
public class EcDefException extends RuntimeException{
    static final long serialVersionUID = -3387516993124229948L;

    public EcDefException() {
    }

    public EcDefException(String message) {
        super(message);
    }


}
