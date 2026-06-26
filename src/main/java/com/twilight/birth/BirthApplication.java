package com.twilight.birth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.twilight.birth.mapper")
public class BirthApplication {
    public static void main(String[] args) {
        SpringApplication.run(BirthApplication.class, args);
    }
}