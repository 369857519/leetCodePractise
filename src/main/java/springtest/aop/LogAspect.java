package springtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        System.out.println(joinPoint.getSignature().getName() +
                Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "springtest.aop.LogAspect.logPointCut()", returning = "result")
    public void logEnd(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() +
                result);
    }
}
