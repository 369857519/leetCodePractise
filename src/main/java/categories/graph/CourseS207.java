package categories.graph;

import java.util.*;

/**
 * Created by 祁连山 on 2019/4/15.
 */
public class CourseS207 {
    public static void main(String[] args) {
        CourseS207 courseS207=new CourseS207();
        boolean res= courseS207.canFinish(3,new int[][]{{0,2},{1,2},{2,0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Node> nodes=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            nodes.add(new Node(i,new ArrayList<>()));
        }
        for(int i=0;i<prerequisites.length;i++){
            nodes.get(prerequisites[i][1]).next.add(nodes.get(prerequisites[i][0]));
        }
        for(Node node:nodes){
            if(!checkCycle(node,numCourses)){
                return false;
            }
        }
        return true;
    }
    public boolean checkCycle(Node node,int length){
        int[] record=new int[length];
        Queue<Node> queue=new LinkedList();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node currentNode=queue.poll();
            if(record[node.val]==1){
                return false;
            }
            record[node.val]=1;
            queue.addAll(node.next);
        }
        return true;
    }
}
