package concurrent.JUC;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    private final StampedLock stampedLock = new StampedLock();

    private double x;

    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();

        double currentX = x;

        double currentY = y;

        //先乐观读，如果发现没修改，直接计算结果即可
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

}
