package Algorithm.categories.toplogicalSort;

public class CourseScheduleII210 {

    public static void main(String[] args) {
        CourseScheduleII210 courseScheduleII210 = new CourseScheduleII210();
        courseScheduleII210.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] node = new int[numCourses];
        int[] indegreeRecord = new int[numCourses];
        int[] recordNode = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegreeRecord[prerequisites[i][0]]++;
        }
        for (int i = 0; i < node.length; i++) {
            node[i] = i;
        }

        boolean canRemove;
        int nodeLength = numCourses;
        int recordIndex = 0;
        int prerequisitesLength = prerequisites.length;
        do {
            canRemove = false;
            for (int i = 0; i < nodeLength; i++) {
                int curNode = node[i];
                if (indegreeRecord[curNode] == 0) {
                    canRemove = true;
                    //deleteNode
                    node[i] = node[nodeLength - 1];
                    nodeLength--;
                    //record node
                    recordNode[recordIndex++] = curNode;
                    //delete path
                    for (int j = 0; j < prerequisitesLength; j++) {
                        if (prerequisites[j][1] == curNode) {
                            indegreeRecord[prerequisites[j][0]]--;
                            prerequisites[j] = prerequisites[prerequisitesLength - 1];
                            prerequisitesLength--;
                            //如果删除了，再看一下新挪过来的这个元素是否符合要求
                            j--;
                        }
                    }
                    //如果删除了，再看一下新挪过来的这个元素是否符合要求
                    i--;
                }

            }
            //record node
        } while (canRemove);
        if(nodeLength!=0){
            return new int[]{};
        }
        return recordNode;
    }

}
