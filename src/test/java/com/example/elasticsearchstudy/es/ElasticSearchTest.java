package com.example.elasticsearchstudy.es;

import com.example.elasticsearchstudy.BaseTest;
import com.example.elasticsearchstudy.util.GenerateUserUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;

import static com.example.elasticsearchstudy.constant.ESConstant.*;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/27 10:23
 */
public class ElasticSearchTest extends BaseTest {
    private Gson gson = new GsonBuilder().serializeNulls().create();

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void test() throws IOException {
        IndexRequest indexRequest = new IndexRequest(ES_USER_INDEX_PREFIX);
        String document = gson.toJson(GenerateUserUtil.generate());
        indexRequest.source(document,XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    }

    /*
    * 手动创建索引
    * */
    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(ES_USER_INDEX_PREFIX);
        //设置索引的配置，1个分片1个副本。由于我们是单机ES，这个配置无关紧要，正式的线上环境记得要配置
        HashMap<String,String> indexOption = new HashMap<>();
        indexOption.put("index.number_of_shards","1");
        indexOption.put("index.number_of_replicas","1");
        createIndexRequest.settings(indexOption);
        //设置索引mapping，即字段的定义
        createIndexRequest.mapping(MAPPING, XContentType.JSON);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(gson.toJson(createIndexResponse));
    }
}
