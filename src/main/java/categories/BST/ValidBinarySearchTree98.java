package categories.BST;

import Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import ppp.ValidateStackSequences;

public class ValidBinarySearchTree98 {

	public static void main(String[] args) {
		ValidBinarySearchTree98 validateStackSequences = new ValidBinarySearchTree98();
		boolean valid = validateStackSequences
			.isValidBST(TreeNode.createTreeByArr(new int[]{5, 1, 7, -1, -1, 6, 8}));
		valid = validateStackSequences
			.isValidBST(TreeNode.createTreeByArr(new int[]{10, 5, 15, -1, -1, 6, 20}));
	}

	public boolean isValidBST(TreeNode root) {
		return traverse(root);
	}

	Stack<Integer> stack = new Stack<>();

	public boolean traverse(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = traverse(root.left);
		if (!stack.empty() && root.val <= stack.peek()) {
			return false;
		}
		stack.push(root.val);
		boolean right = traverse(root.right);
		return left && right;
	}

}
