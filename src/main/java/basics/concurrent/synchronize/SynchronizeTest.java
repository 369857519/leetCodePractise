package basics.concurrent.synchronize;

public class SynchronizeTest {

    private static Object testLock = new Object();

    public static int counter = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (testLock) {
                    for (int j = 0; j < 100; j++) {
                        counter++;
                        System.out.println(Thread.currentThread().getName() + " num:" + j);
                    }

                    if (counter > 500) {
                        return;
                    }
                }
            }, "thread" + i).start();
        }
    }
}
