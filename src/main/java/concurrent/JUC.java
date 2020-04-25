package concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JUC {


    public void Test(){
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        try{

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
