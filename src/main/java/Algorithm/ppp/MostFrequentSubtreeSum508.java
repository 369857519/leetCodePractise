package Algorithm.ppp;

import Algorithm.Utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentSubtreeSum508 {

	public static void main(String[] args) {
		TreeNode test = TreeNode.createTreeByArr(new int[]{5, 2, -3});
		MostFrequentSubtreeSum508 mostFrequentSubtreeSum508 = new MostFrequentSubtreeSum508();
		System.out.println(mostFrequentSubtreeSum508.findFrequentTreeSum(test));
	}

	private Map<Integer, Integer> map = new HashMap<>();
	private int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		postOrder(root);
		List<Integer> list = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	public int postOrder(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = postOrder(root.left);
		int rightSum = postOrder(root.right);
		int current = root.val;
		int sum = current + leftSum + rightSum;
		int freqCount = map.getOrDefault(sum, 0) + 1;
		max = Math.max(max, freqCount);
		return sum;
	}
}
