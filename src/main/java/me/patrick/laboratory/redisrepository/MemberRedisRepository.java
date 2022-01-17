package me.patrick.laboratory.redisrepository;

import me.patrick.laboratory.redisvalue.RedisMember;
import org.springframework.data.repository.CrudRepository;


public interface MemberRedisRepository extends CrudRepository<RedisMember,String> {
}
