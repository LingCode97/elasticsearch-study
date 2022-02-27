package com.example.elasticsearchstudy.util;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

import static com.example.elasticsearchstudy.constant.ESConstant.ES_USER_INDEX_PREFIX;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/27 11:34
 */
@Component
public class ESUtil {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    public void createIndex(String indexName,String mapping,int shards,int replicas) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        //设置索引的配置，1个分片1个副本。由于我们是单机ES，这个配置无关紧要，正式的线上环境记得要配置
        HashMap<String,String> indexOption = new HashMap<>();
        indexOption.put("index.number_of_shards",String.valueOf(shards));
        indexOption.put("index.number_of_replicas",String.valueOf(replicas));
        createIndexRequest.settings(indexOption);
        //设置索引mapping，即字段的定义
        createIndexRequest.mapping(mapping, XContentType.JSON);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    public void addDocument(String document,String indexName) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName);
        indexRequest.source(document,XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    }
}
