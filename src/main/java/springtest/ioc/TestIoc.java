package springtest.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import springtest.PractiseConfiguration;

@Service
public class TestIoc {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PractiseConfiguration.class);
        TestIoc testIoc=applicationContext.getBean(TestIoc.class);
        testIoc.test();
    }
    @Autowired
    private TestService testService;

    public void test(){
        System.out.println(testService.test());
    }
}
