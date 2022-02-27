package com.example.elasticsearchstudy.service;

import com.example.elasticsearchstudy.entity.User;
import com.example.elasticsearchstudy.util.ESUtil;
import com.example.elasticsearchstudy.util.GenerateUserUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.example.elasticsearchstudy.constant.ESConstant.*;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/22 22:17
 * Simulate business methods and write logs
 */
@Service
@Slf4j
public class WriteLogService implements CommandLineRunner{
    @Autowired
    RestHighLevelClient restHighLevelClient;
    @Autowired
    ESUtil esUtil;

    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    @PostConstruct
    public void run() throws Exception {

    }

    @Override
    public void run(String... args) {
        try {
            //运行前检查索引是否存在,不存在就新建一个
            if (!restHighLevelClient.indices().exists(new GetIndexRequest(ES_USER_INDEX_PREFIX), RequestOptions.DEFAULT)) {
                esUtil.createIndex(ES_USER_INDEX_PREFIX, MAPPING, 1, 1);
            }
            while (true) {
                String user = gson.toJson(GenerateUserUtil.generate());
                log.info("generate user:{}", user);
                esUtil.addDocument(user, ES_USER_INDEX_PREFIX);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            log.error("service had exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }
}
