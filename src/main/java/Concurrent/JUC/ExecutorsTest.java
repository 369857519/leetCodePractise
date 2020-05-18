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
            new LinkedBlockingDeque<>(1000), (runnable)->{
                Thread t = new Thread(runnable);
                t.setName("lalala" + atomicInteger.incrementAndGet());
                return t;
        },(runnable,executor)->{
            //10分钟后再run试一下
        });

        executorService.submit(()->{
           System.out.println("start task ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        });
    }
}
