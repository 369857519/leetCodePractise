package basics.proxy;

public class Calculator implements Calculatable{
    public static void main(String[] args) {
        //java实现的时候只能转成实现接口的某个对象，这里如果直接转Calculator会报错
        //java内部使用字节码生成了一个代理类，实现了传入object实现的所有接口
        Calculatable calculator=(Calculatable) MyProxy.getProxy(new Calculator());
        calculator.add(1,2);
        System.out.println(calculator.getClass());
        //cglib有没有接口都可以
        //spring中使用了两种代理类
    }

    public int add(int a, int b) {
        return a+b;
    }
}
