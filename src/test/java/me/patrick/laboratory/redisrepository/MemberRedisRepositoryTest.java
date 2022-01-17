package me.patrick.laboratory.redisrepository;

import me.patrick.laboratory.redisvalue.RedisMember;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRedisRepositoryTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private MemberRedisRepository redisRepository;

    @Test
    void test(){
        RedisMember redisMember = RedisMember.builder()
                .id("OM1")
                .username("유호연")
                .age(33).build();

        redisRepository.save(redisMember);

    }


}