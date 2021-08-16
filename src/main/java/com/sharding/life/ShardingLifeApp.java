package com.sharding.life;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-10 10:42
 */
@SpringBootApplication
@MapperScan(basePackages = { "com.sharding.life.mapper" })
public class ShardingLifeApp {

    public static void main(String[] args) {
        SpringApplication.run(ShardingLifeApp.class, args);
    }

}
