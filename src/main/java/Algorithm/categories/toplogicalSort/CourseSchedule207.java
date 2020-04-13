package Algorithm.categories.toplogicalSort;

public class CourseSchedule207 {

    public static void main(String[] args) {
        CourseSchedule207 courseSchedule207 = new CourseSchedule207();
        boolean res = courseSchedule207.canFinish(2, new int[][]{
            {1, 0}, {0, 1}
        });
        res = courseSchedule207.canFinish(3, new int[][]{
            {2, 0}, {2, 1}
        });
        res = courseSchedule207.canFinish(3, new int[][]{
            {0, 1},
            {0, 2},
            {1, 2}
        });

        res = courseSchedule207.canFinish(2, new int[][]{});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //inDegree record
        int[] inDegreeRecord = new int[numCourses];
        int[] nodeRecord = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            inDegreeRecord[prerequisites[i][0]]++;
        }
        int len = prerequisites.length;
        while (true) {
            boolean ifCanRemove = false;
            //删除入度为0的节点
            for (int i = 0; i < nodeRecord.length; i++) {
                if (nodeRecord[i] != -1 && inDegreeRecord[i] == 0) {
                    ifCanRemove = true;
                    nodeRecord[i] = -1;
                    if (len > 0) {
                        for (int j = 0; j < len; j++) {
                            if (prerequisites[j][1] == i) {
                                inDegreeRecord[prerequisites[j][0]]--;
                                prerequisites[j] = prerequisites[len - 1];
                                len--;
                                j = j - 1;
                            }
                        }
                    }
                }
            }
            if (!ifCanRemove) {
                //没有可以删除的节点，return
                break;
            }
        }

        //判断是否还有节点
        for (int i = 0; i < nodeRecord.length; i++) {
            if (nodeRecord[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
