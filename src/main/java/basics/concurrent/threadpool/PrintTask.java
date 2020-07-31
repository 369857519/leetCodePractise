package basics.concurrent.threadpool;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.concurrent.*;

@AllArgsConstructor
public class PrintTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 50;

    private int start;

    private int end;

    @Override
    protected Integer compute() {
        if (end - start < THRESHOLD) {
            System.out.println(Thread.currentThread().getName() + " start:" + start + " end:" + end);
            return start+end;
        } else {
            int middle = (start + end) / 2;
            PrintTask printTask= new PrintTask(start, middle);
            PrintTask printTask1= new PrintTask(middle, end);
            printTask.fork();
            printTask1.fork();
            return printTask.join()+printTask1.join();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        PrintTask printTask=new PrintTask(0,300);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        Future<Integer> future=forkJoinPool.submit(printTask);
        System.out.println(future.get());
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();

        ExecutorService workStealingPool= Executors.newWorkStealingPool(4);
        workStealingPool.submit(()->{
            Date now=new Date();
            System.out.println(Thread.currentThread()+now.toString());
        });

    }
}
