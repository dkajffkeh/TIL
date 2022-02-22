package me.patrick.laboratory.common.support;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerAspect {

    @Around("execution(* me.patrick.laboratory.mvctest.service.MemberService.transactionTest(..))")
    public Object calculatePerformanceTime(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        result = point.proceed();
        long end = System.currentTimeMillis();

        log.info(point.getSignature().toString());
        log.info("수행시간 -> {}", end - start);

        return result;

    }

}
