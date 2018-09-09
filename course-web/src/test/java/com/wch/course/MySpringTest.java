package com.wch.course;

import com.wch.course.cache.RedisClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@Test
@SpringBootTest
public class MySpringTest extends AbstractTestNGSpringContextTests {

    @Resource
    private RedisClient redisClient;

    public void testRedisClient() {
        redisClient.set("123".getBytes(), "456".getBytes(), 30);

        System.out.println(new String(redisClient.get("123".getBytes())));
    }
}
