package Concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //ThreadPoolExecutor->AbstractExecutorService->ExecutorService
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                10,
                10,
                1000,//多余线程会被终止
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),
                new ThreadFactory() {
                    final ThreadGroup threadGroup=System.getSecurityManager().getThreadGroup();
                    final AtomicInteger threadNumber = new AtomicInteger(1);
                    final String namePrefix="lalal";
                    @Override
                    public Thread newThread(Runnable r) {
                        //可以用来设置Thread的上下文
                        return new Thread(threadGroup,r,namePrefix+threadNumber.getAndIncrement(),0);
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        //可以抛出一个异常
                    }
                }
        );

    }
}
