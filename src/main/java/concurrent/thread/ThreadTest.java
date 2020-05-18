package concurrent.thread;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

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
        t.start();
        Thread.sleep(2000);
        //主线程去打断分线程，分线程停止while循环
        t.interrupt();
        t.join();
        System.out.println("end");
        //守护进程
        //在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。

    }
}
