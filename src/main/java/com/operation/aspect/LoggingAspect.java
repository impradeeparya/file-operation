package com.operation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 11/1/17
 * Time: 10:30 PM
 */

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("within(com.operation.services.impl.*)")
    public void loggedMethod() {
    }

    @Before("loggedMethod()")
    public void beforeLoggedMethod(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " -" + joinPoint.getArgs());
    }

    @After("loggedMethod()")
    public void afterLoggedMethod(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " -" + joinPoint.getArgs());
    }


}
