package concurrent;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        //interrupt()方法仅仅向t线程发出了“中断请求”，至于t线程是否能立刻响应
        Thread t=new Thread(()->{
            System.out.println("123");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();
        t.join();
        System.out.println("end");

    }
}
