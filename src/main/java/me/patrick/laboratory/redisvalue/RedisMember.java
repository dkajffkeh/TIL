package me.patrick.laboratory.redisvalue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@RedisHash(value = "member", timeToLive = 30)
@AllArgsConstructor
@Builder
public class RedisMember {

    @Id
    private String id;

    private String username;

    private int age;

}
