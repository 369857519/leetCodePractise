package concurrent.synchronize;

public class Counter {
    private int count=0;
    //相当于sychronized(this)
    public synchronized void add(int n){
        count+=n;
    }

    private static int static_count=0;
    //相当于sychronized(Counter.class)
    public synchronized  static void addStatic(int n){
        static_count+=n;
    }
}
