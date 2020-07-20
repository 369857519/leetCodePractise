package concurrent.thread;

public class ThreadMethodTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("t--" + i);
            }
        });
        thread.start();
        //强制主线程和其他线程等待，thread执行完之后再执行主线程和其它线程
//        for (int i = 0; i < 5; i++) {
//            System.out.println("m--" + i);
//            if (i == 3) {
//                thread.join();
//            }
//        }

        //阻塞，但是sleep(0)同yield
//        for(int i=0;i<5;i++){
//            System.out.println("m--"+i);
//            if(i==3){
//                Thread.sleep(10);
//            }
//        }

        //yield会将本线程退回到就绪状态，重新开始竞争，有可能会再次竞争成功
        for (int i = 0; i < 5; i++) {
            System.out.println("m--" + i);
            if (i == 3) {
                Thread.yield();
                //礼让并不会保证礼让出去，只是重新退回到抢占资源
                System.out.println("礼让一次");
            }
        }

        //多线程也可以直线唤醒和等待，但是属于共享对象的操作，不在Thread上
    }
}
