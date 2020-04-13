package Algorithm.categories.tree;

import Algorithm.Utils.TreeNode;

public class LowestCommonAncestor236 {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTreeByArr(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
		LowestCommonAncestor236 lowestCommonAncestor236 = new LowestCommonAncestor236();
		TreeNode res = lowestCommonAncestor236
			.lowestCommonAncestor(root, root.left.left, root.right.right);
		res = lowestCommonAncestor236.lowestCommonAncestor(root, root.right.right.left, root.right);
		res = lowestCommonAncestor236.lowestCommonAncestor(root, root.left.left, root.left.right);
		res = lowestCommonAncestor236.lowestCommonAncestor(null, null, null);
		res = lowestCommonAncestor236.lowestCommonAncestor(root, root.left, null);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (p == null && q == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
		TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
		if (leftRes != null && rightRes != null) {
			return root;
		}
		if (leftRes != null && rightRes == null) {
			return leftRes;
		}
		if (leftRes == null && rightRes != null) {
			return rightRes;
		}
		return null;
	}
}
