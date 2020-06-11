package designPattern.Singleton;

public class HolderSingleton {
    private static class HolderSingletonHolder{
        public static final HolderSingleton INSTANCE=new HolderSingleton();
    }
    public static HolderSingleton getInstance(){
        String a=new String("123");
        return HolderSingletonHolder.INSTANCE;

    }

    public static void main(String[] args) {
        int a=-1;
        System.out.println(-1/2);
    }
}
