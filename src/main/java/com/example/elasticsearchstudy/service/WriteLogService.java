package com.example.elasticsearchstudy.service;

import com.example.elasticsearchstudy.util.GenerateUserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/22 22:17
 * Simulate business methods and write logs
 */
@Service
@Slf4j
public class WriteLogService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("generate user:{}",GenerateUserUtil.generate().toString());
    }
}
