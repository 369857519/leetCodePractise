package algorithm.categories.tree;

import algorithm.Utils.TreeNode;

public class BinaryTreeMaximumPathSum124 {

	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	int max = Integer.MIN_VALUE;

	private int helper(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		int left = helper(treeNode.left);
		int right = helper(treeNode.right);
		//左右路径和最大
		int pathLeft = left < 0 ? 0 : left;
		int pathRight = right < 0 ? 0 : right;
		max = Math.max(pathLeft + pathRight + treeNode.val, max);
		//单条路径最大
		int pathMax = Math.max(left, right);
		max = Math.max(pathMax + treeNode.val, max);
		//目前节点的选择，要左，要右，都不要
		return Math.max(pathMax + treeNode.val, treeNode.val);
	}
}
