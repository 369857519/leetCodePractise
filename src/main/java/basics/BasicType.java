package basics;

public class BasicType {
    public static void main(String[] args) {
        Integer a=100;
        Integer b=100;
        Integer c=200;
        Integer d=200;
        System.out.println(a==b);
        System.out.println(c==d);

        //Integer内部会有一个256大小的内存空间，进行了堆内存缓存
        //Double没有这个缓存
        //自动装箱：Integer.valuOf()
        //自动拆箱：integer.intValue()

        //字符串存储是charArray,intern可以找到常量池的位置
        String str="abc";
        String str2=new String("abc");
        System.out.println(str==str2);
        str2=str2.intern();
        System.out.println(str==str2);


        //编译时常量会存到常量池
        String as="abc";
        String bs="def";
        String cs="abcdef";
        String ds=as+bs;
        String es="abc"+"def";
        System.out.println(ds==es);
        System.out.println(cs==es);
    }
}
