package com.manjula.crud.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by manjula on 10/24/17.
 */
@Aspect
@Component
public class LoggingHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.manjula.crud.service..*.*(..))")
    protected void service() {}

    @Around("service()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String args = Arrays.toString(joinPoint.getArgs());
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        try {
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            logger.debug(className + "." + methodName + "(" + args + ") : " + elapsedTime + "ms");
            return result;
        } catch (Exception e) {
            logger.error("Exception " + e.getMessage() + " in " + className + "." + methodName + "(" + args + ")");
            throw e;
        }
    }

}
