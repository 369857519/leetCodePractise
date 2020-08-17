package springtest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import springtest.PractiseConfiguration;

@Component
public class MyCalculator {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PractiseConfiguration.class);
        MyCalculator myCalculator= applicationContext.getBean(MyCalculator.class);
        myCalculator.add(1,2);
    }
    public int add(int i, int j) {
        return i + j;
    }
}
