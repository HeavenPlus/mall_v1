package com.heaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * @Author Heaven
 * @Date 2023/12/10 下午8:09
 */
@SpringBootApplication
@MapperScan("com.heaven.mapper")
@ComponentScans({@ComponentScan("org.n3r.idworker")})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
