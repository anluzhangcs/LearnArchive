package crud.blob;

/**
 * @author: zhanghao
 * @date: 2021/10/23-19:43
 */

import crud.bean.Customer;
import crud.util.JDBCUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 * @Description Blob数据类型测试,Mysql中Blob类型可以存放二进制文件
 *  而PreparedStatement可以操作Bold类型,这也是它的优点之一
 */
public class BlobTest {

    @Test
    //查询含有blob类型数据,将其他数据封装为对象,将blob以文件形式存到本地
    public void resultBlob() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);

            ps.setObject(1, 22);

            rs = ps.executeQuery();

            if (rs.next()) {
                //通过列的别名得到对应的值
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date brith = rs.getDate("birth");
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(email);
                customer.setBirth(brith);
                System.out.println(customer);
                //获取blob类型数据可以用流来二进制流来装
                is = rs.getBinaryStream("photo");

            }

            fos = new FileOutputStream("photo.png");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            JDBCUtils.closeResources2(conn, ps, rs);
        }


    }

    @Test
    public void updateBlob() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "update customers set photo = ? where id = ?";
            ps = conn.prepareStatement(sql);

            FileInputStream fis = new FileInputStream("wangfei.png");
            ps.setBlob(1, fis);
            ps.setObject(2, 22);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn,ps);
        }


    }


    @Test
    //插入一条包含Blob类型的记录
    public void insertBlob() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into customers(name,email,birth,photo) values (?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setObject(1, "张三");
            ps.setObject(2, "123@gmail.com");
            ps.setObject(3, "2001-02-18");
            FileInputStream fis = new FileInputStream("meimei.png");
            ps.setBlob(4, fis);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }

    }

}
