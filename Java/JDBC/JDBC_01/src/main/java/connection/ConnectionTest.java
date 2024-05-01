package connection;

/**
 * @author: zhanghao
 * @date: 2021/10/22-15:02
 */

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description 数据库连接测试
 */
public class ConnectionTest {

    @Test
    public void testConnection1() throws SQLException {

        /*
         *  解释: JDBC是Java用来连接和操作各种数据库的,无关数据库平台,是接口规范
         *      因此java.sql下大部分都是接口,而数据库厂商则根据JDBC向下提供的数据库API
         *      进行编写JDBC的实现类,即数据库驱动程序,因此驱动程序中大部分都是实现类
         *   举例: java.sql.Driver是接口,com.mysql.jdbc.Driver是类
         *
         *   获取数据库连接:driver,url,user,password缺一不可
         */

        //获取Driver实现类
        //注:com.mysql.jdbc已被deprecated,使用com.mysql.cj.jdbc
        Driver driver = new com.mysql.cj.jdbc.Driver();

        //获取数据库资源的定位符
        // jdbc(主协议)+ mysql(子协议)+ localhost(域名) + test(数据库名)+ ?serverTimezone=UTC(时区)
        //注:url后如果不加?serverTimezone=UTC,则会报错The server time zone value '�й���׼ʱ��' is unrecognized
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

        //获取数据库连接信息,user和password
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        //获取数据库连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);

    }

    @Test
    //方式2:方式1的迭代,通过反射获取driver,避免代码中出现第三方API
    public void testConnection2() throws Exception {
        //获取com.mysql.cj.jdbc.Driver类的Class实例
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");

        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");


        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }

    @Test
    //方式3:使用DriverManager代替Driver,避免Driver直接操作
    public void testConnection3() throws Exception {
        //1.获取Driver实现类对象并注册驱动
//        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
//        DriverManager.registerDriver(driver);

        /*
         * DriverManager.registerDriver(driver)可以省略,mysql.cj.jdbc.Driver有
         * 如下静态代码块自己注册驱动
         * static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
    }
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.指定其他三个信息
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String user = "root";
        String password = "root";

        //3.获取连接,调用getConnection(String url,String user,String password)
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    @Test
    /*
     * @Description  方式4(final版) 使用配置文件装连接数据库所需的信息
     *  优点:
     *      1.数据和代码分离,解耦,是程序具有更好的移植性
     *      2.部署到服务器上时,如需修改连接,只需更改配置文件,不用重新打包
     */
    public void testConnection4() throws Exception {
        //1.加载配置文件jdbc.properties
        //注:ClassLoader加载的是编译之后的classes目录下
        InputStream is =
                ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties info = new Properties();
        info.load(is);

        //2.加载驱动
        Class.forName(info.getProperty("driver"));

        //3.调用DriverManager.getConnection()获取连接
        Connection connection = DriverManager.getConnection(info.getProperty("url"), info.getProperty("user"), info.getProperty("password"));
        System.out.println(connection);
    }

}
