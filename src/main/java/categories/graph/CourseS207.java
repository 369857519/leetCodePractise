package categories.graph;

import java.util.*;

/**
 * Created by 祁连山 on 2019/4/15.
 */
public class CourseS207 {
    public static void main(String[] args) {
        CourseS207 courseS207=new CourseS207();
        boolean res= courseS207.canFinish(3,new int[][]{{1,0},{2,1}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDe=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inDe[prerequisites[i][1]]++;
        }
        while(true){
            for(int i=0;i<numCourses;i++){
                if(inDe[i]==0){
                    for(int j=0;j<prerequisites.length;j++){
                        int[] temp=prerequisites[j];
                        if(temp[0]==i){
                            inDe[temp[1]]--;
                            temp[0]=-1;
                        }
                    }
                    inDe[i]=-1;
                }
            }
            //判断目前是否还有入度为0的元素，如果没有了，break
            boolean hasZero=false;
            for(int i=0;i<inDe.length;i++){
                if(inDe[i]==0){
                    hasZero=true;
                }
            }
            if(!hasZero){
                break;
            }
        }
        for(int i=0;i<inDe.length;i++){
            if(inDe[i]!=-1){
                return false;
            }
        }
        return true;
    }
}
