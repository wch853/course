package com.wch.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CourseApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApiGatewayApplication.class, args);
    }
}
