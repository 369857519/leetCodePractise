package Singleton;

public class HungerSigleton {

    private static HungerSigleton INSTANCE=new HungerSigleton();

    public static HungerSigleton getInstance(){
        return INSTANCE;
    }
}
