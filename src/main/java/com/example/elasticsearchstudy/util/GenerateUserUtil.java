package com.example.elasticsearchstudy.util;

import com.example.elasticsearchstudy.entity.User;
import com.github.javafaker.Faker;

import java.util.Date;
import java.util.UUID;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/22 22:17
 */
public class GenerateUserUtil {
    private static final Faker faker = new Faker();

    public static User generate(){
        return new User()
                .setId(System.currentTimeMillis())
                .setTraceId(UUID.randomUUID().toString())
                .setName(faker.name().name())
                .setBirthday(DateFormat.format(faker.date().birthday(18,60)))
                .setJob(faker.job().title())
                .setAddress(faker.address().fullAddress())
                .setCompany(faker.company().name());
    }
}
