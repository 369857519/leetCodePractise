package basics.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyProxy {
    public static Object getProxy(final Object object) {
        //被代理对象的类加载器
        ClassLoader classLoader = object.getClass().getClassLoader();
        //被代理对象的接口
        Class<?>[] interfaces = object.getClass().getInterfaces();
        InvocationHandler invocationHandler = (Object proxy, Method method, Object[] args) -> {
            Object res = null;
            try {
                System.out.println("method name " + method.getName() + " param:" + Arrays.asList(args));
                res = method.invoke(object, args);
                System.out.println("method return: " + res);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return res;
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
