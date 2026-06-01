package dev.raseen.redis_playground.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.raseen.redis_playground.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/redis")
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/set/{name}")    
    public String setName(@PathVariable String name) {
        redisService.saveName(name);
        return "Saved" + name;
    }

    @GetMapping("/get")
    public String getName() {
        return redisService.getName();
    }
}
