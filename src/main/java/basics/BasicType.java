package basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BasicType {
    public static void main(String[] args) throws ParseException {
        //数字：Integer内部会有一个256大小的内存空间，进行了堆内存缓存
        //Double没有这个缓存
        //自动装箱：Integer.valuOf()
        //自动拆箱：integer.intValue()
        Integer a=100;
        Integer b=100;
        Integer c=200;
        Integer d=200;
        System.out.println(a==b);
        System.out.println(c==d);

        //字符串：字符串存储是charArray,intern可以找到常量池的位置
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

        //字符串辅助：线程安全，大部分加了synchroinzed
        StringBuffer stringBuffer=new StringBuffer(24);
        stringBuffer.append(1231).append(false).append('s');
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.capacity());
        //线程不安全
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(10213);
        stringBuffer.insert(10,'f');
        System.out.println(stringBuilder);

        //时间处理
        Date date=new Date();
        System.out.println(date.getTime());
        System.out.println(new Date(date.getTime()));
        System.out.println(date.after(new Date()));
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        System.out.println(dateFormat.parse("2020-9-10 20:20:20"));
        //calendar 日期复杂处理
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONDAY));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //Math
        Math.sqrt(10);
        Math.ceil(10.232);
        Math.abs(-1);

        //enum
        //多个属性，ordinal，valueOf

        /***集合框架
         * collection
         *  list
         *  set
         *  map
         */
        Collection collection=new ArrayList();
        collection.add(1);
        collection.add("123");
        Collection collection1=new ArrayList();
        collection1.add(1);
        System.out.println("retain all"+collection.retainAll(collection1));
        System.out.println(collection);
        Object[] objects = collection.toArray();

        List list=new ArrayList();
        list.add(213);
        list.add("asd");

        /***
         * list
         *  ArrayList
         */
        //ArrayList扩容 1.5倍、线程不安全
        list.iterator();// ListIterator extends Iterator
        //ArrayList迭代器用两个指针完成，hashNext用cursor==size来判断
        //删除操作会报错，需要用listIterator
        //使用 listIterator来实现删除操作
        ListIterator listIterator=list.listIterator();
        while(listIterator.hasNext()){
            Object o=listIterator.next();
            if(o.equals(213)){
                listIterator.remove();
            }
            System.out.println(o);
        }
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        /***
        Set 接口
        Set
            HashSet
                LinkedHashSet
            TreeSet
         */

        //HashSet.put其实是hashMap.put("",PRESENT);
        HashSet hashSet=new HashSet();
        hashSet.add(12);
        //iterator会被即使回收，for写法比较好
        for(Iterator iterator=hashSet.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        for(Object o:hashSet){
            System.out.println(o);
        }

        TreeSet treeSet=new TreeSet();
        treeSet.add("123");
        treeSet.add("222");
        //treeSet.add(1); treeSet需要类型一致，因为没办法

        /***
        Map
            HashMap 哈希表+链表+红黑树
                DEFAULT_INITTIAL_CAPACITY = 1<<4
                    must be a power of 2。为什么算法导论建议不太接近
                    整数幂的素数，是一个合适的选择，但是工程中用的是16
                    1、方便进行取模运算，只需要直接与运算就就可以找到位置
                    2、扩容的时候只需要加一个最高位运算即可
                MAXIMUM_CAPACITY 1<<30
                DEFAULT_LOAD_FACTOR=0.75f
                为什么8的时候，转链表：
                    泊松分布统计，8以上的节点出现的概率极低，
                    所以可以用比较重的数据结构替换，解决边界
                    问题同时保证不会因为大范围链表换红黑树导致效率下降
                hash实现
                    (h = key.hashCode()) ^ (h >>> 16)
                resize中链表的处理
                    头插法
                resize中树的处理
            LinkedHashMap Entry中拥有before和after
            TreeMap 红黑树

         */
        new HashMap();

        Collections.sort(new ArrayList<Integer>());
        Collections.binarySearch(new ArrayList<>(),10);
        Collections.shuffle(new ArrayList<>());
        Collections.reverse(new ArrayList<>());
        int[] array=new int[]{1,2,3};
        List<Integer> integers= Arrays.asList(1,2,3);
        integers.toArray();
    }
}
