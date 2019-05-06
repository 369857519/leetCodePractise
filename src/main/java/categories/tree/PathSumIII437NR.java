package categories.tree;

import Utils.TreeNode;
import java.util.HashMap;

public class PathSumIII437NR {

	public static void main(String[] args) {
		TreeNode testNode = TreeNode
			.createTreeByArr(new int[]{10, 5, -3, 3, 2, -1, 11, 3, -2, -1,});
		PathSumIII437NR pathSumIII437 = new PathSumIII437NR();
		pathSumIII437.pathSum(testNode, 8);
	}

	public int pathSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		return traverse(root, 0, sum, preSum);
	}

	//返回这棵树中有的个数
	//map: key之前的数字的和 value有多少种路径能到这个位置，每到一次都加一
	public int traverse(TreeNode node, int current, int target, HashMap<Integer, Integer> preSum) {
		if (node == null) {
			return 0;
		}
		current += node.val;
		int res = preSum.getOrDefault(current - target, 0);
		preSum.put(current, preSum.getOrDefault(current, 0) + 1);

		res += traverse(node.left, current, target, preSum) + traverse(node.right, current, target,
			preSum);
		preSum.put(current, preSum.get(current) - 1);
		return res;
	}
}
