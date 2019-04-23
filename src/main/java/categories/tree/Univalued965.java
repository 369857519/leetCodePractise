package categories.tree;

import Utils.TreeNode;

public class Univalued965 {

	public static void main(String[] args) {
		TreeNode treeNode = TreeNode.createTreeByArr(new int[]{1, 1, 1, 1, 1, -1, 1});
		Univalued965 univalued965 = new Univalued965();
		boolean res = univalued965.isUnivalTree(treeNode);
	}

	public boolean isUnivalTree(TreeNode root) {
		if (null == root) {
			return true;
		}
		boolean currentNodeJudge = false;
		if (root.left != null && root.right != null) {
			currentNodeJudge = root.val == root.left.val && root.val == root.right.val;
		}
		if (root.left != null && root.right == null) {
			currentNodeJudge = root.val == root.left.val;
		}
		if (root.left == null && root.right != null) {
			currentNodeJudge = root.val == root.right.val;
		}
		if (root.left == null && root.right == null) {
			currentNodeJudge = true;
		}
		boolean leftTreeJudge = isUnivalTree(root.left);
		boolean rightTreeJudge = isUnivalTree(root.right);
		return currentNodeJudge && leftTreeJudge && rightTreeJudge;
	}
}
