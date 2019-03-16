package ppp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Permutations46 {

    public static void main(String[] args) {
        Permutations46 permutations46 = new Permutations46();
        List<List<Integer>> list = permutations46.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(list, temp, nums);
        return list;
    }

    public void permute(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(temp.contains(nums[i]))continue;
                temp.add(nums[i]);
                permute(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }


}

