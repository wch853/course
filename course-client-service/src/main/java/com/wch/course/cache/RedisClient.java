package com.wch.course.cache;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, int timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void expire(String key, int timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public void set(byte[] key, byte[] value, int timeout) {
        redisTemplate.execute((RedisCallback<Object>) redisConnection -> {
            redisConnection.set(key, value);
            redisConnection.expire(key, timeout);
            return null;
        });
    }

    public byte[] get(byte[] key) {
        return redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.get(key);
            }
        });
    }

}
