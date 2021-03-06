package com.xufq.loginserver.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisUtil {
    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
    }

    public <T> T get(String key) {
        try {
            ValueOperations operations = redisTemplate.opsForValue();
            return (T) operations.get(key);
        } catch (Exception ex) {
            log.warn("Redis类型转换失败。key: " + key);
        }
        return null;
    }

    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    public String getUserInfoKey(String token) {
        StringBuffer s = new StringBuffer();
        s.append("UserInfoKey")
                .append(":")
                .append(token);
        return s.toString();
    }
}
