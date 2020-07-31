package basics.concurrent.JUC;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock rlock = lock.readLock();
    private final Lock wlock = lock.writeLock();

    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock();
        try {
            counts[index] += 1;
        } finally {
            wlock.lock();
        }
    }

    public int[] get() {
        rlock.lock();
        try {
            Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock();
        }
        return null;
    }

}
