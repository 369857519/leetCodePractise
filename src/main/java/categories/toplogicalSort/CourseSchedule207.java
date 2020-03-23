package categories.toplogicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule207 {

    public static void main(String[] args) {
        CourseSchedule207 courseSchedule207 = new CourseSchedule207();
        courseSchedule207.canFinish(2, new int[][]{
            {1, 0}, {0, 1}
        });
        courseSchedule207.canFinish(3, new int[][]{
            {2, 0}, {2, 1}
        });
        courseSchedule207.canFinish(3, new int[][]{
            {0, 1},
            {0, 2},
            {1, 2}
        });
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //inDegree record
        int[] inDegreeRecord = new int[numCourses];

        Map<Integer, List<Integer>> prerequisitesMap = new HashMap();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegreeRecord[prerequisites[i][0]]++;
            prerequisitesMap.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            prerequisitesMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        List<Integer> entrances = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegreeRecord[i] == 0) {
                entrances.add(i);
            }
        }
        for (Integer entrance : entrances) {
            visit(entrance, prerequisitesMap, inDegreeRecord);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegreeRecord[i] != 0) {
                return false;
            }
        }
        return true;
    }

    //每一次删除无前驱节点
    public void visit(int start, Map<Integer, List<Integer>> relationMap, int[] inDegreeRecord) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (relationMap.get(cur) != null) {
                for (int i : relationMap.get(cur)) {
                    queue.offer(i);
                    inDegreeRecord[i]--;
                }
                relationMap.remove(cur);
            }
        }
    }
}
