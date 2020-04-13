package Algorithm.categories.graph;

import java.util.*;

/**
 * Created by 祁连山 on 2019/4/18.
 */
public class FESS802 {
    public static void main(String[] args) {
        FESS802 fess802 = new FESS802();
        fess802.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
        fess802.eventualSafeNodes(new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}});
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, Set<Integer>> record = new HashMap<>();
        Map<Integer, Set<Integer>> reverseRecord = new HashMap<>();

        List<Integer> resList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            record.put(i, new HashSet<>());
            reverseRecord.put(i, new HashSet<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                record.get(i).add(graph[i][j]);
                reverseRecord.get(graph[i][j]).add(i);
            }
            if(graph[i].length==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int nextNode = queue.poll();
            //删除入度的
            for (int x : reverseRecord.get(nextNode)) {
                record.get(x).remove(nextNode);
                if (record.get(x).isEmpty()) {
                    queue.offer(x);
                }
            }
            resList.add(nextNode);
        }
        Collections.sort(resList);
        return resList;
    }

}

