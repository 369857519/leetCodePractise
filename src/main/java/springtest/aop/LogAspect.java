package springtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* springtest.aop.MyCalculator.*(..))")
    public void logPointCut() {
    }

    @Before("springtest.aop.LogAspect.logPointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("start:" + joinPoint.getSignature().getName() +
                Arrays.asList(joinPoint.getArgs()));
    }

    @After("springtest.aop.LogAspect.logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("after:" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "springtest.aop.LogAspect.logPointCut()", returning = "result")
    public void logEnd(JoinPoint joinPoint, Object result) {
        System.out.println("afterReturning:" + joinPoint.getSignature().getName() +
                result);
    }

    @AfterThrowing(value = "springtest.aop.LogAspect.logPointCut()", throwing = "result")
    public void logThrow(JoinPoint joinPoint, Throwable result) {
        //do recovery actions
        System.out.println("afterThrowing:" + result.getMessage());

    }

}
