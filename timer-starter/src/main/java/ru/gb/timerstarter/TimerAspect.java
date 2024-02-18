package ru.gb.timerstarter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Aspect
@Slf4j
public class TimerAspect {

    @Pointcut("@annotation(ru.gb.timerstarter.Timer)")
    public void methodPointcut() {

    }

    @Around("methodPointcut()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis() - start;
        log.info("Method: {} Execution time: {} msec", joinPoint.getSignature().getName(), end);
        return result;
    }
}
