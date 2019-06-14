package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @描述
 * @创建人 wangyue
 * @创建时间2019/6/129:39
 */

@SpringBootApplication//@SpringBootConfiguration配置@EnableAutoConfiguration自动配置ComponentScan扫描
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }
    @Bean //实例化对象
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
