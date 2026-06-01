package dev.raseen.redis_playground.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveName(String name) {
        redisTemplate.opsForValue()
                .set("name", name);
    }

    public String getName() {
        return redisTemplate.opsForValue()
                .get("name");
    }
}
