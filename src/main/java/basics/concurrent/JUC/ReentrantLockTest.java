package basics.concurrent.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ReentrantLockTest {

    private final Lock lock=new java.util.concurrent.locks.ReentrantLock();
    private int count;

    public static void main(String[] args) {

    }

    //
    public void add(int n){
        lock.lock();
        try{
            count+=n;
        }finally {
            lock.unlock();
        }
    }

    public void addWithTimeLimit(int n) throws InterruptedException {
        //如果1秒没有获得到锁，就处理其他逻辑
        if(lock.tryLock(1,TimeUnit.SECONDS)){
            try{
                count+=n;
            }finally {
                lock.unlock();
            }
        }
    }

    //Condition

}
