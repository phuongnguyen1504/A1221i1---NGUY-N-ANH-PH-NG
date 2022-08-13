package com.book.AOP;

import com.book.model.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LogCheck {
    private int visited=0;
    @Before(value = "count_visited()")
    public void beforeController(){
        ++visited;
        System.out.println("Number visited: "+visited);
    }

    @Pointcut(value = "within(com.book.controller.*)")
    public void count_visited(){
    }
    //Tạo aspect cho các phương thức thay đổi cart
    //Toàn bộ phương thức
    @AfterReturning("execution(* com.book.service.BookServiceImpl.*(..))")
    public void logAfterReturningAllServiceMethods(JoinPoint joinPoint) throws Throwable
    {
        System.out.println("****LoggingAspect.logAfterReturningAllServiceMethods() ");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[%s] Hành động thay đổi thư viện của ServiceImpl : %s. Phương thức: %s. Tham số: %s", LocalDate.now(), className, method, args));
    }
    //Áp dụng cho trả về return có tham số
    @AfterReturning(pointcut="execution(* com.book.model.Cart.getBookObject(..))", returning="retVal")
    public void logAfterReturningGetBookObject(Object retVal) throws Throwable
    {
        System.out.println("****LoggingAspect.logAfterReturningGetBookObject() ");
        System.out.println("Kết quả trả về:"+(Book)retVal);
    }
    //Áp dụng cho phương thức cụ thể nhưng k có return như void
    @AfterReturning("execution(* com.book.model.Cart.addBook(..))")
    public void logAfterReturningAddCartInBook() throws Throwable
    {
        System.out.println("****LoggingAspect.logAfterReturningAddCartInBook() ");
    }
    @AfterReturning("execution(* com.book.model.Cart.backBook(..))")
    public void logAfterReturningBackBook() throws Throwable
    {
        System.out.println("****LoggingAspect.logAfterReturningBackBook() ");
    }

    @AfterThrowing(pointcut = "execution(* com.book.controller.BookController.backbook(..))",throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        String method=joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[%s] Đã có lỗi : %s. Phương thức: %s. Tham số: %s. Message: %s", LocalDate.now(), className, method, args,ex.getMessage()));

    }
}
