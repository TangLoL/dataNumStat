package com.fiberhome.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by zyf on 2017/12/12.
 */
@Aspect
@Component
public class Monitor {
    Logger logger = Logger.getLogger(Monitor.class);
    @Pointcut("execution(* com.fiberhome..*Controller.*(..))")
    public void controller(){

    }
    @Before("controller()")
    public void doAop(JoinPoint joinPoint){
        logger.info(joinPoint.getStaticPart());
//        logger.info(joinPoint);
    }
    @AfterReturning(returning = "ret",pointcut = "controller()")
    public void logServiceAccess(JoinPoint joinPoint,Object ret) {
        if (ret!=null)
            logger.info("return message is ;" +ret.toString());
        else
            logger.info("return message is : null");
    }
}
