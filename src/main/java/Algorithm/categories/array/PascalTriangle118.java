package Algorithm.categories.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle118 {

    public static void main(String[] args) {
        PascalTriangle118 pascalTriangle118 = new PascalTriangle118();
        pascalTriangle118.generate(6);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0){
            return list;
        }
        list.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            int nextLength = i + 1;
            Integer[] curList = new Integer[nextLength];
            curList[0] = 1;
            curList[nextLength - 1] = 1;
            List<Integer> lastList = list.get(list.size() - 1);

            for (int j = 0; j < nextLength / 2 - 1; j++) {
                int val = lastList.get(j) + lastList.get(j + 1);
                curList[j + 1] = val;
                curList[nextLength - j - 2] = val;
            }

            if (nextLength % 2 != 0) {
                curList[nextLength / 2] = lastList.get(nextLength / 2) * 2;
            }
            list.add(Arrays.asList(curList));
        }
        return list;
    }

}
