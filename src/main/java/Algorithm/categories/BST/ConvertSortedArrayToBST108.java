package Algorithm.categories.BST;

import Algorithm.Utils.TreeNode;

public class ConvertSortedArrayToBST108 {

	public static void main(String[] args) {
		ConvertSortedArrayToBST108 convertSortedArrayToBST108 = new ConvertSortedArrayToBST108();
		TreeNode treeNode = convertSortedArrayToBST108.sortedArrayToBST(new int[]{1, 2});
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return traverse(nums, 0, nums.length - 1);
	}

	public TreeNode traverse(int[] nums, int l, int h) {
		TreeNode curNode = null;
		if (l < h) {
			int mid = l + h >>> 1;
			curNode = new TreeNode(nums[mid]);
			curNode.left = traverse(nums, l, mid - 1);
			curNode.right = traverse(nums, mid + 1, h);
		} else if (l == h) {
			curNode = new TreeNode(nums[l]);
		}
		return curNode;
	}
}
