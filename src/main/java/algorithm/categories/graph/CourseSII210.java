package algorithm.categories.graph;

/**
 * Created by 祁连山 on 2019/4/17.
 */
public class CourseSII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDe=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inDe[prerequisites[i][0]]++;
        }
        int currentIndex=0;
        int[] res=new int[numCourses];
        while(true){
            for(int i=0;i<numCourses;i++){
                if(inDe[i]==0){
                    for(int j=0;j<prerequisites.length;j++){
                        int[] temp=prerequisites[j];
                        if(temp[1]==i){
                            inDe[temp[0]]--;
                            temp[1]=-1;
                        }
                    }
                    res[currentIndex++]=i;
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
                return new int[0];
            }
        }
        return res;
    }
}
