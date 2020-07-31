package basics.concurrent.consumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private String name;

    private String brand;

    private boolean flag=false;

    public synchronized void set(String brand,String name){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        setFlag(true);
        notify();
        System.out.println("生产者生产了"+this.getBrand()+this.getName());

    }

    public synchronized void get(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlag(false);
        notify();
        System.out.println("消费者取走了"+this.getBrand()+this.getName());
    }
}
