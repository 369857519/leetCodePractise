package springtest.ioc;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String test(){
        return "hello world";
    }
}
