package categories.dp.MinimumOrMaximumPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {

    public static void main(String[] args) {
        Triangle120 triangle120 = new Triangle120();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{2}));
        list.add(Arrays.asList(new Integer[]{3, 4}));
        list.add(Arrays.asList(new Integer[]{6, 5, 7}));
        list.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        triangle120.minimumTotal(list);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //bottom to top
        List<Integer> bottom = null;
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            if (bottom != null) {
                for (int j = 0; j < list.size(); j++) {
                    int cur = list.get(j);
                    cur = Math.min(bottom.get(j), bottom.get(j + 1)) + cur;
                    list.set(j, cur);
                }
            }
            bottom = list;
        }
        return triangle.get(0).get(0);
    }

}
