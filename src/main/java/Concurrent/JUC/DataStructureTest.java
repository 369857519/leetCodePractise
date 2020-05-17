package concurrent.JUC;

import java.util.Deque;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class DataStructureTest {

    public static void main(String[] args) {

        //ArrayList
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
        list.add(1);

        //HashMap
        ConcurrentHashMap<Integer,Integer> map=new ConcurrentHashMap<>();
        map.put(10,10);

        //Set
        Set<Integer> set=new CopyOnWriteArraySet<>();
        set.add(10);

        //Queue
        Queue<Integer> queue=new ArrayBlockingQueue(100);
        ((ArrayBlockingQueue<Integer>) queue).offer(10);

        queue=new LinkedBlockingDeque<>();
        try {
            ((LinkedBlockingDeque<Integer>) queue).offer(10,10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Deque
        Deque<Integer> deque=new LinkedBlockingDeque<>();

    }



}
