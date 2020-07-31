package basics.concurrent.consumer.jucversion;

import basics.concurrent.consumer.Goods;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
@AllArgsConstructor
@NoArgsConstructor
public class ProducerQueue implements Runnable {

    private BlockingQueue blockingQueue;

    @SneakyThrows
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("生产者生产商品"+i);
            if(i%2==0){
                blockingQueue.put(Goods.builder().brand("旺仔").name("小馒头").build());
            }else{
                blockingQueue.put(Goods.builder().brand("哇哈哈").name("矿泉水").build());
            }
        }
    }
}
