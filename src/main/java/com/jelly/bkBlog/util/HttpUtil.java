package com.jelly.bkBlog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jelly on 2016-8-12.
 */
public class HttpUtil {
    protected static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String HEAD = "HEAD";

    public static String getContent(String uri, String requestMethod, int timeout) {
        StringBuffer content = null;
        HttpURLConnection conn = null;
        InputStream in = null;

        try {
            URL url = new URL(uri);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(timeout / 2);
            conn.setReadTimeout(timeout / 2);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
            conn.connect();

            content = new StringBuffer();
            in = conn.getInputStream();
            BufferedReader inRd = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String inputLine;
            while ((inputLine = inRd.readLine()) != null) {
                content.append(inputLine).append(Const.LineSeparator);
            }
        } catch (IOException e) {
            if(conn != null)closeInputStreamAnyway(conn.getErrorStream());
            log.error("http error", e);
        } finally {
            closeInputStreamAnyway(in);
        }

        if(content != null){
            return content.toString();
        }

        return null;
    }

    public static void closeInputStreamAnyway(InputStream inputStream){
        if(inputStream == null){
            return;
        }


        try {
            if(inputStream != null) inputStream.close();
        }catch (Exception e){

        }
    }

    public static void closeOutputStreamAnyway(OutputStream outputStream){
        if(outputStream == null){
            return;
        }

        try {
            if(outputStream != null) outputStream.close();
        }catch (Exception e){

        }
    }
}
