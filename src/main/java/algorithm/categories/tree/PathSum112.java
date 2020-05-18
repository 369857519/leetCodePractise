package algorithm.categories.tree;

import algorithm.Utils.TreeNode;

public class PathSum112 {

	public static void main(String[] args) {
		TreeNode treeNode = TreeNode.createTreeByArr(new int[]{-2, -1, -3});
		PathSum112 pathSum112 = new PathSum112();
		boolean res = pathSum112.hasPathSum(treeNode, -5);
	}

	int currentInt = 0;

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		currentInt += root.val;
		boolean res;
		if (currentInt == sum && root.left == null && root.right == null) {
			res = true;
		} else {
			res = hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
		}
		currentInt -= root.val;
		return res;
	}
}
