package designPattern.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        Kissable kissable =(Kissable) enhancer.newProxy(new MyLover());
        kissable.kiss();
    }
}
