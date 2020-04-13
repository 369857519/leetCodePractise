package Algorithm.ppp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

	public static void main(String[] args) {
		CombinationSum39 combinationSum39 = new CombinationSum39();
		combinationSum39.combinationSum(new int[]{2, 3, 6, 7}, 7);
		combinationSum39.combinationSum(new int[]{2, 3, 5}, 8);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> lists = new ArrayList<>();
		search(lists, new ArrayList<>(), candidates, 0, 0, target);
		return lists;
	}

	public void search(List<List<Integer>> res, List<Integer> path, int[] cadidates,
		int curSum, int lastIndex, int target) {
		if (curSum > target) {
			return;
		}
		if (curSum == target) {
			res.add(new ArrayList<>(path));
		}
		for (int i = lastIndex; i < cadidates.length; i++) {
			curSum += cadidates[i];
			path.add(cadidates[i]);
			search(res, path, cadidates, curSum, i, target);
			curSum -= cadidates[i];
			path.remove(path.size() - 1);
		}
		return;
	}

}

