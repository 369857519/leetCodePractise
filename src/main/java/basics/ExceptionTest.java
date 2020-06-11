package basics;

import java.util.HashMap;
import java.util.Map;

public class ExceptionTest {
    public static void main(String[] args) {
//        testReturnFinal();
        System.out.println(finallyReturnCover());
        System.out.println(finallyNoReturnCoverFailed());
        System.out.println(finallyNoReturnObjCover());
    }
    //finally必定执行
    public static void testReturnFinal() {
        try {
            System.out.println(10);
            throw new Exception("出异常啦");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            System.out.println("finally");
        }
    }

    //return cover的情况
    //return会有一个返回值缓存，只有在finally也有return语句的情况下，才会改变返回值缓存

    //finally return 改变返回值缓存
    public static int finallyReturnCover() {
        int num = 10;
        try {
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return num + 10;
        }
    }

    //finally 无return，改变便量值，返回值没变
    public static int finallyNoReturnCoverFailed(){
        int num=10;
        try{
            throw new Exception("123");
        }catch (Exception e){
            return num;
        }finally {
            num=100;
        }
    }

    //finally 无return，改变对象值
    public static Map<Integer,Integer> finallyNoReturnObjCover(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        try{
             return map;
        }catch (Exception e){
        }finally {
            map.put(0,-1);
        }
        return map;
    }

}
