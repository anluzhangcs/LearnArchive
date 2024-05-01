package log4j2;

/**
 * @author: zhanghao
 * @date: 2021/12/1-11:34
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;

/**
 * @Description 测试Log4j2日志框架
 */
public class Log4j2Test {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("afasdf");
    }
}
