package Singleton;

public class LazySingleton {
    //加入LazySingleton实例化过程中有一堆属性也需要实例化，
    //这些代码是卸载这个实例化之前的，这个时候有可能重排导致INSTANCE已经不为空，但是实例化并未完全OK
    //如果构造函数写入非 final 字段，则不必立即将它们提交到内存，甚至可以在单例变量之后提交。构造函数其实已经完成，但这并不意味着所有写入对其它线程可见。
    //最终倒是另一个线程的调用失败，这个时候需要用上vol
    private static volatile LazySingleton INSTANCE;

    public static LazySingleton getInstance(){
        //提高效率
        if(INSTANCE==null){
            synchronized (LazySingleton.class){
                if(INSTANCE==null){
                    INSTANCE=new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
