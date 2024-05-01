package upload;

/**
 * @author: zhanghao
 * @date: 2021/11/2-12:39
 */


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用第三方工具类对上传的数据进行解析

        //1.判断请求中的数据是否是多段数据拼接的二进制流,只有如此才能使用ServletFileUpload解析
        if (ServletFileUpload.isMultipartContent(req)) {

            //创建FileItem工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析数据的ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            List<FileItem> fileItems = null;
            try {
                //对req的上传数据进去解析,获得表单项list集合
                fileItems= servletFileUpload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            //对解析数据得到的表单项集合进行遍历,每一项就是一个表单
            for (FileItem f : fileItems) {

                //判断表单项是普通表单还是文件表单,true为普通表单,false为其他
                if (f.isFormField()) {
                    String fieldName = f.getFieldName();
                    System.out.println("表单项的name属性值:"+fieldName);
                    String value = f.getString("utf-8"); //防止中文乱码
                    System.out.println("表单项的value属性值:"+value);
                } else{
                    String name = f.getName();
                    System.out.println("上传的文件名"+name);
                    String fieldName = f.getFieldName();
                    System.out.println("表单项的name属性值:"+fieldName);
                    //将二进制数据流写入到文件
                    try {
                        f.write(new File("d:\\" + name));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
