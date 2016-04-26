package com.example.servlet_http.response.download;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by Xin.Lee on 2016/4/26.
 * 文件以附件形式下载
 */
public class DownloadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = null;
        // 如果图片的名称带有中文，则下载后的文件中文部分将是乱码
        String imgRealPath = getServletContext().getRealPath("/img/天才J.jpg");
        int index = imgRealPath.lastIndexOf("\\");
        if(index != -1) {
            filename = imgRealPath.substring(index + 1);
        }
        if(filename != null) {
            // 解决文件名称乱码, 先判断浏览器类型
            // IE URL编码     火狐 BASE64编码
            String userAgent = request.getHeader("user-agent");
            // IE7-IE10包含MSIE   IE11包含Trident和rv:11
            if(userAgent.contains("MSIE") || (userAgent.contains("Trident") && userAgent.contains("rv:11"))) {
                filename = URLEncoder.encode(filename, "UTF-8");
            }
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            // 获取文件输入流
            FileInputStream fis = new FileInputStream(imgRealPath);
            // 获取向浏览器输出的输出流
            OutputStream os = response.getOutputStream();
            byte [] b = new byte[1024];
            int len;
            while((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
            }
            fis.close();
            // 输出流服务器会默认关闭
            os.close();
        }
    }

}
