package com.awesome.questionslib.core.spring.aspect;

import com.awesome.questionslib.exception.EntityNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class ExceptionHandlerAspect {

    @Pointcut("execution(public * com.awesome.questionslib.controller.*.*(..))")
    private void anyControllerMethod() {
    }

    @Around("anyControllerMethod()")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (EntityNotFoundException notFoundException) {
            return ResponseEntity.notFound();
        } catch (Exception exp) {
            return ResponseEntity.internalServerError();
        }
    }

}
