package com.example.elasticsearchstudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/22 22:22
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String traceId;
    private String name;
    private String birthday;
    private String job;
    private String address;
    private String company;

}
