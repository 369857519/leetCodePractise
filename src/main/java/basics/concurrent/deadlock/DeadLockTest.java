package basics.concurrent.deadlock;

public class DeadLockTest {

    private static Object lock1=new Object();

    private static Object lock2=new Object();

    public static void main(String[] args) {
        new Thread(()->{
           synchronized (lock1){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (lock2){
                   System.out.println("locked both lock");
               }
           }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("locked both lock");
                }
            }
        }).start();
    }
}
