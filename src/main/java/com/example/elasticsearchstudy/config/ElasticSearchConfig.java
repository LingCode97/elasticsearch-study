package com.example.elasticsearchstudy.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/27 09:52
 * 为了初学期方便理解，手动初始化es客户端，不使用springboot的自动配置功能
 */
@Configuration
@Slf4j
public class ElasticSearchConfig{
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient restHighLevelClient = null;
        try {
            log.info("elasticsearch start init...");
            restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));
            log.info("elasticsearch init success!");
        }catch (Exception e){
            log.error("elasticsearch init had exception:{}", ExceptionUtils.getStackTrace(e));
        }
        return restHighLevelClient;
    }
}
