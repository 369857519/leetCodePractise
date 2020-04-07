package categories.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {

    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        threeSum15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        threeSum15.threeSum(new int[]{1, 1, -2});
        threeSum15.threeSum(new int[]{0, 0, 0});
        threeSum15.threeSum(new int[]{-2, 1, 1, 1, 1, 1, 1});
        threeSum15.threeSum(new int[]{-1, 0, 1, 0});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Set<Integer> numsSet = new HashSet<>();
        Set<Integer> userdSet = new HashSet<>();
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                addRes(list, numsSet, userdSet, nums[i], nums[j], zeroCount);
            }
        }
        return list;
    }


    public boolean use(int i, int j, int z, Set<Integer> usedPairs, int zeroCount) {
        if (usedPairs.contains(i * 3 + j * 7 + z * 11)) {
            return false;
        } else {
            //0判断
            if (i == 0 && j == 0 && z == 0) {
                usedPairs.add(0);
                if (zeroCount < 3) {
                    return false;
                }
            } else {
                usedPairs.add(i * 3 + j * 7 + z * 11);
                usedPairs.add(i * 3 + z * 7 + j * 11);
                usedPairs.add(j * 3 + i * 7 + z * 11);
                usedPairs.add(j * 3 + z * 7 + i * 11);
                usedPairs.add(z * 3 + j * 7 + i * 11);
                usedPairs.add(z * 3 + i * 7 + j * 11);
            }
            return true;
        }
    }

    public void addRes(List<List<Integer>> res, Set<Integer> numsSet, Set<Integer> usedPairs,
        int numi, int numj, int zeroCount) {
        if (use(numi, numj, (-(numi + numj)), usedPairs, zeroCount) && numsSet
            .contains(-(numi + numj))) {
            List<Integer> resSub = new ArrayList<>();
            resSub.add(numi);
            resSub.add(numj);
            resSub.add(-(numi + numj));
            res.add(resSub);
        }
    }

}
