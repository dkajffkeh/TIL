package me.patrick.laboratory.mvctest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisTestController {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisTestController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // set
    @PostMapping("")
    public String setRedisKey(@RequestBody Map<String, String> req){
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        vop.set(req.get("key"), req.get("value"));
        return "set message success";
    }
}
