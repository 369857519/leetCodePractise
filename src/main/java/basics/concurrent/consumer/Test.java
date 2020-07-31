package basics.concurrent.consumer;

public class Test {
    public static void main(String[] args) {
        Goods goods=new Goods();
        Producer producer=new Producer(goods);
        Consumer consumer=new Consumer(goods);
        Thread producerT=new Thread(producer);
        Thread consumerT=new Thread(consumer);
        producerT.start();
        consumerT.start();
    }
}
