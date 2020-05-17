package algorithm.categories.BST;

import algorithm.Utils.TreeNode;

public class KthSmallest230 {

	public static void main(String[] args) {
		KthSmallest230 kthSmallest230 = new KthSmallest230();
		int val = kthSmallest230
			.kthSmallest(TreeNode.createTreeByArr(new int[]{3, 1, 4, -1, 2}), 1);
		kthSmallest230.index = 1;
		val = kthSmallest230
			.kthSmallest(TreeNode.createTreeByArr(new int[]{5, 3, 6, 2, 4, -1, -1, 1}), 3);
	}

	int index = 1;

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int left = kthSmallest(root.left, k);
		if (k == index++) {
			return root.val;
		}
		if (left != Integer.MAX_VALUE) {
			return left;
		}
		int right = kthSmallest(root.right, k);
		return right;
	}
}
