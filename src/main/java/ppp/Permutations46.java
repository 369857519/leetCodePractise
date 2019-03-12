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
		List<List<Integer>> list = permutations46.permute(new int[]{1, 1, 2});
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList();
		List<Integer> tempList = new ArrayList<>();
		Arrays.sort(nums);
		getList(list, tempList, nums, new boolean[nums.length]);
		return list;
	}

	public void getList(List<List<Integer>> permutes, List<Integer> numRecord, int[] nums,
		boolean[] used) {
		if (nums.length == numRecord.size()) {
			permutes.add(new ArrayList<>(numRecord));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				used[i] = true;
				numRecord.add(nums[i]);
				getList(permutes, numRecord, nums, used);
				used[i] = false;
				numRecord.remove(numRecord.size() - 1);
			}
		}
	}
}

