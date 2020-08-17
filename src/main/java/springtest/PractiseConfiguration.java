package springtest;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springtest.aop.LogAspect;
import springtest.aop.MyCalculator;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "springtest")
public class PractiseConfiguration {
}
