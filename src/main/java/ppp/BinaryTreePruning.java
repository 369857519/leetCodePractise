package ppp;

import Utils.TreeNode;

public class BinaryTreePruning {

	public TreeNode pruneTree(TreeNode root) {
		TreeNode resRoot = pruneNode(root);
		return resRoot;
	}

	public TreeNode pruneNode(TreeNode node) {
		if (node == null) {
			return null;
		}
		node.left = pruneNode(node.left);
		node.right = pruneNode(node.right);
		if (node.left == null && node.right == null && node.val == 0) {
			return null;
		}
		return node;
	}
}
