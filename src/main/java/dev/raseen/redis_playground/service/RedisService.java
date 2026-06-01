package dev.raseen.redis_playground.service;

import java.util.Map;

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

    public void saveUser(Long id, String name, String age, String city) {
        String key = "user:" + id;

        redisTemplate.opsForHash()
                .put(key, "name", name);

        redisTemplate.opsForHash()
                .put(key, "age", age);

        redisTemplate.opsForHash()
                .put(key, "city", city);
    }

    public Object getUserFields(Long id, String field) {
        String key = "user:" + id;

        return redisTemplate.opsForHash()
                .get(key, field);
    }

    public Map<Object, Object> getUsers(Long id) {
        String key = "user:" + id;

        return redisTemplate.opsForHash()
                .entries(key);
    }
}
