package Algorithm.ppp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {

	public static void main(String[] args) {
		CombinationSum40 combinationSum39 = new CombinationSum40();
		combinationSum39.combinationSum2(new int[]{2, 3, 6, 7}, 7);
		combinationSum39.combinationSum2(new int[]{2, 3, 5}, 8);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> lists = new ArrayList<>();
		Arrays.sort(candidates);
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
			//保证不选重复的方式：在本次循环中如果遇到已经选过的，就跳过
			if (i > lastIndex && cadidates[i] == cadidates[i - 1]) {
				continue;
			}
			path.add(cadidates[i]);
			search(res, path, cadidates, curSum + cadidates[i], i, target);
			path.remove(path.size() - 1);
		}
		return;
	}

}

