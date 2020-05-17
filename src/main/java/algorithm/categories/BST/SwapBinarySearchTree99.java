package algorithm.categories.BST;

import algorithm.Utils.TreeNode;

import java.util.Stack;

public class SwapBinarySearchTree99 {

	public static void main(String[] args) {
		SwapBinarySearchTree99 swapBinarySearchTree99 = new SwapBinarySearchTree99();
		swapBinarySearchTree99
			.recoverTree(TreeNode.createTreeByArr(new int[]{1, 3, -1, -1, 2}));
		swapBinarySearchTree99 = new SwapBinarySearchTree99();
		swapBinarySearchTree99
			.recoverTree(TreeNode.createTreeByArr(new int[]{3, 1, 4, -1, -1, 2}));
		swapBinarySearchTree99 = new SwapBinarySearchTree99();
		swapBinarySearchTree99
			.recoverTree(TreeNode.createTreeByArr(new int[]{3, 4}));

	}

	Stack<TreeNode> stack = new Stack<>();

	//第一个非法元素之前的那个元素和最后一个非法元素换位置即可
	public void recoverTree(TreeNode root) {
		if (root.left == null && root.right == null) {
			return;
		}
		traverse(root);
		int temp = first.val;
		first.val = next.val;
		next.val = temp;
	}

	TreeNode first = null;
	TreeNode next = null;

	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		if (!stack.empty() && root.val < stack.peek().val) {
			//找到一个非法元素
			if (first == null) {
				first = stack.peek();
			}
			next = root;
		}
		stack.push(root);
		traverse(root.right);
	}
}
