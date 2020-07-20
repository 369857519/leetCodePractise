package concurrent.consumer.jucversion;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerQueue implements Runnable {

    private BlockingQueue blockingQueue;

    @SneakyThrows
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("消费者消费的商品是"+blockingQueue.take());
        }
    }
}
