package basics.concurrent.thread;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        //线程生命周期：
        // 新生：调用start之后进入新生状态，分配了内存空间、调用start()进入就绪状态
        // 就绪：
        //      就绪状态的线程可运行，但是没有分配到CPU
        //      当系统选定一个等待执行的县城后，他就会从就绪态进入执行态，这个动作数据“CPU调度”
        // 运行:
        //        在给定时间片内进行执行，如果没执行完会回到就绪态
        // 阻塞:
        //      让出CPU，进入阻塞状态。阻塞状态不能进入就绪队列，、
        //      只有引起阻塞的时间消除以后，才能进入就绪队列，等待执行
        //      进入方式：1、sleep 2、等待IO
        // 死亡:
        //      最后一个阶段
        //      进入方式：1、线程执行完毕 2、线程被stop 3、程序抛出未捕获的异常

        //为什么建议用runnable，java有单继承特性，
        // 一般业务中如果继承了Thread，那这个类就不能级成别的业务类，使用不太灵活
        // 所以建议把业务类继承关系给更需要的父类，而不是级成Thread
        //interrupt()方法仅仅向t线程发出了“中断请求”，至于t线程是否能立刻响应
        Thread t = new Thread(() -> {
            System.out.println("123");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int n = 0;
            while (!Thread.interrupted()) {
                n++;
                System.out.println(n + "hello!");
            }
        });
        System.out.println(t.isAlive());

        t.start();
        Thread.sleep(2000);
        //主线程去打断分线程，分线程停止while循环
        t.interrupt();
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.isAlive());
        t.setPriority(10);
        //在一般系统中是1-10，如果没有设置默认5.有些系统是0-100
        //优先执行的概率比较大，但是不一定肯定优先执行
        System.out.println(t.getPriority());
        //调用该方法的线程强制执行，其他线程出于阻塞状态，该线程执行完毕以后，其它线程再执行
        t.join();
        //当前线程暂停一次，允许其它线程执行，当前线程不阻塞，马上进行排队
        Thread.yield();
        System.out.println(t.isAlive());
        System.out.println("end");
        //守护进程
        //在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
        t.setDaemon(false);

    }
}
