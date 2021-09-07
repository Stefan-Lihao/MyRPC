package com.lh.rpc.communication;

import com.lh.rpc.protocol.Endpoint;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;

/**
 * 客户端通信
 */

public class HttpTransportClient implements TransportClient {

    private static final String PREFIX = "http://";
    private HttpURLConnection httpConnect;
    private String url;

    @Override
    public void connect(Endpoint endpoint) {
        this.url = PREFIX + endpoint.getHost() + ":" + endpoint.getPort();
    }

    @Override
    public InputStream write(InputStream data, RequestMethod requestMethod) {
        try {
            httpConnect = (HttpURLConnection) new URL(url).openConnection();
            httpConnect.setDoOutput(true);
            httpConnect.setDoInput(true);
            httpConnect.setUseCaches(false);
            httpConnect.setRequestMethod(requestMethod.name());

            //建立连接
            httpConnect.connect();

            //发送数据
            IOUtils.copy(data, httpConnect.getOutputStream());

            int responseCode = httpConnect.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return httpConnect.getInputStream();
            } else {
                return httpConnect.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void close() {
        if (httpConnect != null) {
            httpConnect.disconnect();
        }
    }
}