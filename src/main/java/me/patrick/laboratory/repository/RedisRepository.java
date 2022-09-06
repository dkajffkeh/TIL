package me.patrick.laboratory.repository;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean lock(Long key) {
        return redisTemplate.opsForValue()
                .setIfAbsent(generateKet(key), "lock", Duration.ofSeconds(3_000));
    }

    public Boolean unLock(Long key) {
        return redisTemplate.delete(generateKet(key));
    }

    private String generateKet(Long key) {
        return key.toString();
    }

}
