package com.itmuch.yes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author itmuch.com
 */
@SpringBootApplication
@MapperScan("com.itmuch.yes.mapper")
public class YesApplication {
    public static void main(String[] args) {
        SpringApplication.run(YesApplication.class, args);
    }
}
