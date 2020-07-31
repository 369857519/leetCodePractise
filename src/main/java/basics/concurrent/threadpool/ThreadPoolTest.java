
package basics.concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //线程会占用系统资源，为什么要用线程池
        //  1、线程池可以重复利用已有的线程继续执行任务、避免创建和销毁时造成损耗
        //  2、由于没有线程创建和销毁时的消耗，可以提高系统响应速度
        //  3、通过对线程的合理管理，可以动态的调整系统的线程池大小，对应不同情况的需求

        //提交过程
        // 提交任务->判断核心线程池是否已满->判断阻塞队列是否已满->判断线程池max是否已满->执行
        //          否：创建新线程         否：放到队列中        否：创建新线程执行

        //线程池类型
        //ThreadPoolExecutor->AbstractExecutorService->ExecutorService
//        execute(Executors.newCachedThreadPool());
//        execute(Executors.newFixedThreadPool(5));
//        execute(Executors.newSingleThreadExecutor());

        //ScheduledThreadPoolExecutor
//        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);
//        System.out.println(System.currentTimeMillis());
//        scheduledExecutorService.scheduleAtFixedRate(()->{
//            System.out.println(System.currentTimeMillis());
//        },1,3,TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(()->{
//            System.out.println("-"+System.currentTimeMillis());
//        },1,3,TimeUnit.SECONDS);

        //FolkJoinPool
        //见PrintTask

        //线程池生命周期：
        //RUNNING
        //SHUTDOWN 不再接受新的任务，旧的任务还需要处理完
        //STOP 立即终止
        //TIDYING 任务处理完，workerCount为0
        //TERMINATED 结束状态，理论上不做什么事儿

        //线程池常用阻塞队列
        //ArrayBlockingQueue 生产和消费会公用一个锁对象，队列需要只定长度
        //ThreadBlockingQueue 生产者和消费者用了两个锁，队列有没有最大长度限制
        //PriorityBlockingQueue 采用公平锁，队列采用优先队列。同时不会阻塞生产者
        //DelayQueue 必须等到时间到了，才能取到对应的元素
        //SynchronousQueue 没有任务缓冲区，直接发给任务执行者

        //拒绝策略
        //ThreadPoolExecutor.AbortPolicy 默认策略：丢弃任务，抛出拒绝异常
        //ThreadPoolExecutor.DiscardPolicy 丢弃同时不抛出异常
        //ThreadPoolExecutor.DiscardOldestPolicy 丢弃最前面的
        //ThreadPoolExecutor.CallerRunsPolicy 由调用线程处理该任务

        //ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                10,
                16,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>()
        );
//        execute(threadPoolExecutor);

        //submit会有返回对象,execute没有返回值
        Future<Integer> submit = threadPoolExecutor.submit(() -> {
            return 10;
        });
        System.out.println(submit.get());
        threadPoolExecutor.shutdown();
    }
    public static void execute(ExecutorService executorService){
        for(int i=0;i<20;i++){
            executorService.execute(()->{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
