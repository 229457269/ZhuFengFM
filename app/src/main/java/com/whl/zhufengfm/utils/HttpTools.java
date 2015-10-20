package com.whl.zhufengfm.utils;

import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Project_name : ZhuFengFM
 * Author : zhaoQiang
 * Email : 229457269@qq.com
 * Create_time : 2015/10/20 | 10:50
 */
public final class HttpTools {
    private HttpTools() {
    }

    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 10000;
    public static final String UER_AGENT = "ting_4.1.7(" + Build.MODEL + "," + Build.VERSION.SDK_INT + ")";

    /**
     * 根据url地址下载数据，返回字节数组
     * @param url 地址
     * @return
     */

    public static byte[] doGet(String url) {
        Log.i("info",url+"=====");
        byte[] ret = null;
        if (url != null) {
            HttpURLConnection connection = null;
            try {
                URL u = new URL(url);
                connection = (HttpURLConnection) u.openConnection();

                //
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.setReadTimeout(READ_TIMEOUT);

                connection.setRequestMethod("GET");
                //设置Accept头信息，告诉服务器，客户端可以接受什么样的数据。。
                connection.setRequestProperty("Accept", "application/*,text/*,image/*,*/*");

                //设置接受的内容压缩格式
                connection.setRequestProperty("Accept-Encoding","gzip");


                //设置 user-agent
                connection.setRequestProperty("User-Agent", UER_AGENT);

                connection.connect();
                int code = connection.getResponseCode();
                if (code == 200) {
                    InputStream fin = null;

                    fin = connection.getInputStream();
                    //TODO  进行网络输入流的压缩
                    String encoding = connection.getHeaderField("Content-Encoding");

                    if("gizp".equals(encoding)){
                        fin = new GZIPInputStream(fin);
                    }

                    ret = StreamUtils.readStream(fin);

                    Log.i("info",ret.toString());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtils.close(connection);
            }
        }
        return ret;
    }

    /**
     * 执行post请求
     *
     * @param url
     * @param map
     */
    public static void doPost(String url, HashMap<String, String> map) throws UnsupportedEncodingException {

        if (url != null) {

            //把药提交的数据组织起来
            StringBuilder sb = new StringBuilder();

            for (Map.Entry<String, String> en : map.entrySet()) {
                sb.append(en.getKey())
                        .append("=")
                        .append(URLEncoder.encode(en.getValue(), "utf-8"));
            }


            HttpURLConnection connection = null;

            try {
                URL u = new URL(url);
                connection = (HttpURLConnection) u.openConnection();

                //基本设置
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setDoOutput(true);
                connection.setDoInput(true);

                //设置提交的数据的类型
                connection.setRequestProperty("Content-Type", "application/x-www-from-urlencoded");
                connection.connect();

                //设置提交的数据
                byte[] b = sb.toString().getBytes();

                //提交数据，向服务端写入数据
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(b, 0, b.length);
                outputStream.close();

                InputStream in = null;
                if (connection.getResponseCode() == 200) {
                    in = connection.getInputStream();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
