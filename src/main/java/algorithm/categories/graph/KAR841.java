package algorithm.categories.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 祁连山 on 2019/4/14.
 */
public class KAR841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       int[] visited=new int[rooms.size()];
        Queue<Integer> queue=new LinkedList();
        while(!queue.isEmpty()){
            int currentRoom=queue.poll();
            if(visited[currentRoom]==0){
                visited[currentRoom]=1;
                List<Integer> keys= rooms.get(currentRoom);
                queue.addAll(keys);
            }
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                return false;
            }
        }
        return true;
    }
}
