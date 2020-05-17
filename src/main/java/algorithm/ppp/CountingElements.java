package algorithm.ppp;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {
    public int countElements(int[] arr) {
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<arr.length;i++){
            int currentCount=map.getOrDefault(arr[i],0);
            map.put(arr[i],currentCount+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(map.containsKey(entry.getKey()+1)){
                count+=entry.getValue();
            }
        }
        return count;
    }
}
