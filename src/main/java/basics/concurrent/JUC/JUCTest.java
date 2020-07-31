package basics.concurrent.JUC;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JUCTest {
    public static void main(String[] args) {

    }
    public static void Test(){
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        try{

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
