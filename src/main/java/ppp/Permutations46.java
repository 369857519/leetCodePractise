package ppp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


//https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
public class Permutations46 {

	public static void main(String[] args) {
		Permutations46 permutations46 = new Permutations46();
		List<List<Integer>> list = permutations46.permute(new int[]{1, 2, 3});
	}

	public List<List<Integer>> permute(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			getList(nums, nums[i]);
		}
		return permutes;
	}

	List<List<Integer>> permutes = new ArrayList<>();
	Set<Integer> numRecord = new HashSet<>();
	Stack<Integer> stk=new Stack<>();

	public void getList(int[] nums, int currentNum) {
		if (numRecord.contains(currentNum)) {
			return;
		}
		numRecord.add(currentNum);
		stk.push(currentNum);
		if (nums.length == numRecord.size()) {
			permutes.add(new ArrayList<>(stk));
		} else {
			for (int i = 0; i < nums.length; i++) {
				getList(nums, nums[i]);
			}
		}
		stk.pop();
		numRecord.remove(currentNum);
	}
}

