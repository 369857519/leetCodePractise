package Algorithm.categories.BST;

import Algorithm.Utils.TreeNode;
import java.util.Stack;

public class MinAbsoluteDistance530 {

	public static void main(String[] args) {
		TreeNode treeNode=TreeNode.createTreeByArr(new int[]{7,3,8});
		MinAbsoluteDistance530 minAbsoluteDistance530=new MinAbsoluteDistance530();
		minAbsoluteDistance530.getMinimumDifference(treeNode);
	}

	Stack<Integer> stack = new Stack<>();

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = getMinimumDifference(root.left);
		int current = Integer.MAX_VALUE;
		if (!stack.empty()) {
			current = root.val - stack.peek();
		}
		stack.push(root.val);
		int rightMin = getMinimumDifference(root.right);
		return Math.min(Math.min(leftMin, current), rightMin);
	}
}
