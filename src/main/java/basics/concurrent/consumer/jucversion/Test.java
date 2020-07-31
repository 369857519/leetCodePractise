package basics.concurrent.consumer.jucversion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(5);
        Thread producerT = new Thread(new ProducerQueue(queue));
        Thread consumerT = new Thread(new ConsumerQueue(queue));
        producerT.start();
        consumerT.start();
    }
}
