package com.operation.aspect;

import org.apache.log4j.Logger;
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

    private static Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Pointcut("within(com.operation.services.impl.*)")
    public void loggedMethod() {
    }

    @Before("loggedMethod()")
    public void beforeLoggedMethod(JoinPoint joinPoint) {
        LOGGER.debug("<METHOD>");
        LOGGER.debug(joinPoint.getSignature());
    }

    @After("loggedMethod()")
    public void afterLoggedMethod(JoinPoint joinPoint) {
        LOGGER.debug(joinPoint.getSignature());
        LOGGER.debug("</METHOD>");
    }


}
