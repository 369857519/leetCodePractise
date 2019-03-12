package ppp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

	public static void main(String[] args) {
		CombinationSum39 combinationSum39 = new CombinationSum39();
		combinationSum39.combinationSum(new int[]{2, 3, 6, 7}, 7);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backTrack(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	public void backTrack(List<List<Integer>> list, List<Integer> temp, int[] candidates,
		int remain,
		int start) {
		if (remain == 0) {
			list.add(new ArrayList<>(temp));
		} else if (remain < 0) {
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				backTrack(list, temp, candidates, remain - candidates[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	}
}

