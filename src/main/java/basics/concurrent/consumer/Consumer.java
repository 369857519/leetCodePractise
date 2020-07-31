package basics.concurrent.consumer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer implements Runnable {

    private Goods goods;

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            goods.get();
        }
    }
}
