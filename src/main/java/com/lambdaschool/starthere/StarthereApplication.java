package com.lambdaschool.starthere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StarthereApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarthereApplication.class, args);
    }

}
