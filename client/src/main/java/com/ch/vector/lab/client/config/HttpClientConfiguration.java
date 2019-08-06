/**
 * @create 2019-08-06 16:18
 * @desc config httpclient
 **/
package com.ch.vector.lab.client.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public HttpClient getHttpClient() {
        RequestConfig.Builder builder = RequestConfig.custom();
        builder.setSocketTimeout(5*1000);
        builder.setConnectTimeout(5*1000);
        RequestConfig requestConfig = builder.build();
        final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        poolingHttpClientConnectionManager.setMaxTotal(500);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(50);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        httpClientBuilder.setDefaultRequestConfig(requestConfig);

        HttpClient httpClient = httpClientBuilder.build();

        Timer timer = new Timer();
        //fix time recycle resource
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                poolingHttpClientConnectionManager.closeExpiredConnections();
                poolingHttpClientConnectionManager.closeIdleConnections(5,TimeUnit.SECONDS);
            }
        },10*1000,5*1000);

        System.out.println("initialed httpclient over ");
        return httpClient;
    }
}

