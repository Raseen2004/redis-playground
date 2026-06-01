package dev.raseen.redis_playground.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.raseen.redis_playground.service.RedisService;

import java.util.Map;

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

    @PostMapping("/user/{id}")
    public String createUser(@PathVariable Long id, @RequestParam String name, @RequestParam String age,
            @RequestParam String city) {
        redisService.saveUser(id, name, age, city);
        return "User" + name + "Saved";
    }

    @GetMapping("/user/{id}")
    public Map<Object, Object> getUser(@PathVariable Long id) {
        return redisService.getUsers(id);
    }

    @GetMapping("/user/{id}/{field}")
    public Object getField(@PathVariable Long id, @PathVariable String field) {
        return redisService.getUserFields(id, field);
    }
}
