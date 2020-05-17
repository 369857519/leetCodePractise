package concurrent.JUC;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsTest {

    private static final AtomicInteger atomicInteger=new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(1000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("lalala" + atomicInteger.incrementAndGet());
                return t;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //两种选择，让另外一个线程池处理
                //抛弃，报一个log
            }
        });
    }
}
