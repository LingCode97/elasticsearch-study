package com.example.elasticsearchstudy.constant;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/27 10:45
 */
public class ESConstant {
    public static final String ES_USER_INDEX_PREFIX = "user";

    public static final String MAPPING ="{\n" +
            "        \"properties\": {\n" +
            "          \"id\":{\n" +
            "            \"type\": \"long\"\n" +
            "          },\n" +
            "          \"traceId\":{\n" +
            "            \"type\": \"keyword\"\n" +
            "          },\n" +
            "          \"name\":{\n" +
            "            \"type\": \"text\"\n" +
            "            , \"analyzer\": \"standard\"\n" +
            "          },\n" +
            "          \"birthday\":{\n" +
            "            \"type\": \"date\"\n" +
            "          },\n" +
            "          \"job\":{\n" +
            "            \"type\": \"text\"\n" +
            "            , \"analyzer\": \"standard\"\n" +
            "          },\n" +
            "          \"address\":{\n" +
            "            \"type\": \"text\"\n" +
            "            , \"analyzer\": \"standard\"\n" +
            "          },\n" +
            "          \"company\":{\n" +
            "            \"type\": \"text\"\n" +
            "            , \"analyzer\": \"standard\"\n" +
            "          }\n" +
            "        }\n" +
            "    }";

}
