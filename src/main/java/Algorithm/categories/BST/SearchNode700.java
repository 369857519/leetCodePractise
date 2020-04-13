package Algorithm.categories.BST;

import Algorithm.Utils.TreeNode;

public class SearchNode700 {

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		} else if (val > root.val) {
			return searchBST(root.right, val);
		} else {
			//左子树
			return searchBST(root.left, val);
		}
	}
}
