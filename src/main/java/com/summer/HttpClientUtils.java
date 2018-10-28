package com.summer;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class HttpClientUtils {
    public static void main(String[] args) {
        String url = "http://www.3322.org/dyndns/getip";
        HttpHost httpHost = new HttpHost("118.190.95.35", 9001, "http");
        String text = doGet(url, httpHost, null);
        System.out.println(text);
    }

    public static String doGet(String uri, HttpHost httpHost, List<Header> headerList) {
        HttpClientBuilder builder = HttpClients.custom();
        if (httpHost != null) {
            builder.setProxy(httpHost);
        }

        CloseableHttpClient httpclient = builder.build();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if (headerList != null) {
                for (Header header : headerList)
                    httpGet.setHeader(header);
            }
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

}
