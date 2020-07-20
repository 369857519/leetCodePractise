package concurrent.consumer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producer implements Runnable {

    private Goods goods;

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            if(i%2==0){
                goods.set("哇哈哈","矿泉水");
            }else{
                goods.set("旺仔","小馒头");
            }
        }
    }
}
