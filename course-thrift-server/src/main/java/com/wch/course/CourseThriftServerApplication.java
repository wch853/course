package com.wch.course;

import com.alibaba.boot.dubbo.autoconfigure.DubboAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DubboAutoConfiguration.class)
public class CourseThriftServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseThriftServerApplication.class, args);
    }
}
