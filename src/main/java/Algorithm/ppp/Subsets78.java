package Algorithm.ppp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {

	public static void main(String[] args) {
		Subsets78 subsets78 = new Subsets78();
		List<List<Integer>> list = subsets78.subsets(new int[]{1, 2, 2});
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		subSet(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void subSet(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
		list.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			subSet(list, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
