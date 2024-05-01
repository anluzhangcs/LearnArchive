package download;

/**
 * @author: zhanghao
 * @date: 2021/11/2-15:00
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * @Description 从服务器下载文件
 */
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求下载的文件名
        String filename = "default.jpg";
        System.out.println(filename);

        //2.服务器通过ServletContext域对象读取文件
        ServletContext servletContext = getServletContext();
        InputStream resource = servletContext.getResourceAsStream("/images/"+filename);

        //3.通过响应头告诉客户端要下载该文件,并告诉客户端MIME文件类型
        //3.1 告诉客户端回传的数据MIME文件类型
        String mimeType = servletContext.getMimeType("/images/" + filename);
        resp.setContentType(mimeType);
        /*
         * 3.2 告诉客户端要下载该文件.
         *  Content-Disposition表示如何处理该文件;attachment表示附件,即要下载该文件
         *  fileName指下载的文件名,可以和服务器端的资源文件名不同
         *
         *  当fileName为中文时,下载文件时文件名会出现乱码情况.解决方案:
         *  谷歌浏览器:对fileName进行URL编码
         *  火狐浏览器:对fileName进行Base64编码
         *  ==>获取request请求头中的浏览器信息,若为Google,则URL编码;反之则Base64编码,即可解决所有浏览器
         *  都能下载且文件名不会乱码
         */
        if (req.getHeader("user-agent").contains("Chrome")){

            resp.setHeader("Content-Disposition","attachment; fileName="+ URLEncoder.encode("猫女.jpg","utf-8"));
        } else{
            resp.setHeader("Content-Disposition","attachment; " +
                    "fileName="+"=?utf-8?B?"+ Base64.getEncoder().encode("中文.jpg".getBytes("utf-8"))+"?=");
        }
//        resp.setHeader("Content-Disposition","attachment; fileName=猫女.jpg");


        //4.读取资源的输入流,并复制到response的输出流,使用第三方工具类
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resource, outputStream);

    }
}
