package com.picture.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import sun.util.logging.resources.logging;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@Aspect
public class BadWordException extends Exception {


    public BadWordException() {
    }

    public BadWordException(String s) {
        super(s);
    }

    @AfterThrowing(pointcut = "execution(public * com.picture.service.PictureServiceImpl.* (..))",throwing = "e")
    public void log(Exception e){
//        String className=joinpoint.getTarget().getClass().getSimpleName();
//        String method=joinpoint.getSignature().getName();
//        String args= Arrays.toString(joinpoint.getArgs());

//        System.out.println(String.format("[%s] co loi xay ra: %s.%s  %s: %s",LocalDate.now(),className,method,args,e.getMessage()));
        System.out.println(String.format("[%s] co loi xay ra kia: %s",LocalDate.now(),e.getMessage()));
    }
}
