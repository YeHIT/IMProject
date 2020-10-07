package cn.yesomething.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

//用于向IM后台发送json
public class MyServerToIMServerSender {

    /**
     * @param url 传入需要访问的IM后台链接
     * @param obj 传入请求包对象
     * @return 返回IM后台返回的应答包
     * @throws Exception
     */
    public static String sendPost(String url, Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MyImProjectLogger.LOGGER.info("sendPost url:" + url + ",postData:" + mapper.writeValueAsString(obj));
        String param = mapper.writeValueAsString(obj);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        HttpURLConnection conn = null;
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        conn = (HttpURLConnection) realUrl.openConnection();
        conn.setRequestMethod("POST");
        // 设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 设置连接超时时间
        conn.setConnectTimeout(3000);
        conn.setRequestProperty("Content-type", "application/json;charset=utf-8");
        conn.setRequestProperty("Charset", "UTF-8");

        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        out = new PrintWriter(conn.getOutputStream());
        // 发送请求参数
        out.print(param);
        // flush输出流的缓冲
        out.flush();
        // 定义BufferedReader输入流来读取URL的响应
        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if (out != null) {
            out.close();
        }
        if (in != null) {
            in.close();
        }
        MyImProjectLogger.LOGGER.info("res=" + result);
        return result;
    }


}
