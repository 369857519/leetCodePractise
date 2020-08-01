package basics.reflect;

import basics.reflect.model.Student;
import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz=Class.forName("java.lang.Integer");
        System.out.println(clazz.getInterfaces());
        System.out.println(clazz.getName());
        clazz=Integer.class;
        clazz=new Integer(1).getClass();
        clazz=Integer.TYPE;//基本数据类型还可以通过.TYPE

        clazz= Student.class;
        //获取共有属性
        for(Field field:clazz.getFields()){
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }
        //获取所有的属性
        for(Field field:clazz.getDeclaredFields()){
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }

        //修改值
        Field address=clazz.getDeclaredField("address");
        System.out.println(address.getName());
        Object o=clazz.newInstance();
        address.setAccessible(true);
        address.set(o,"北京市");
        System.out.println(((Student)o).getAddress());

        //获取能访问到的所有public方法
        for(Method method:clazz.getMethods()){
            System.out.println(method.getName());
        }

        //获取当前类中所有的方法
        for(Method method:clazz.getDeclaredMethods()){
            System.out.println(method.getName());
        }

        Method method=clazz.getDeclaredMethod("setAddress",String.class);
        method.invoke(o,"lalala");
        System.out.println(((Student)o).getAddress());
        
        //获取共有构造方法
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor.getName());
        }
        Constructor constructor=clazz.getConstructor(String.class,String.class,String.class,String.class);
        Student student= (Student ) constructor.newInstance("test","","","");
        System.out.println(student.getAddress());
    }
}
