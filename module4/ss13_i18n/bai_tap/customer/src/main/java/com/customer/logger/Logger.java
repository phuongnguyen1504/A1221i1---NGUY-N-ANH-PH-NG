package com.customer.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.customer.service.CustomerService.*(..))",throwing = "e")
    public void error(JoinPoint joinpoint, Exception e){
        String className=joinpoint.getTarget().getClass().getSimpleName();
        String method=joinpoint.getSignature().getName();
        String args= Arrays.toString(joinpoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s  %s: %s",className,method,args,e.getMessage()));
    }
}
