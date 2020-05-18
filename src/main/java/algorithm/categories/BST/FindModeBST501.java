package algorithm.categories.BST;

import algorithm.Utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindModeBST501 {

	public static void main(String[] args) {
		int[] res = new FindModeBST501().findMode(TreeNode.createTreeByArr(new int[]{1, -1, 2, 2}));

		res = new FindModeBST501().findMode(TreeNode.createTreeByArr(new int[]{1, 1, 2}));

		res = new FindModeBST501().findMode(TreeNode.createTreeByArr(new int[]{1, 2}));
	}

	TreeNode lastNode = null;
	int currentModeCount = 0;
	int count = 0;
	Set<Integer> record = new HashSet<>();

	public int[] findMode(TreeNode root) {
		lastNode = null;
		traverse(root);
		return convertIntegers(record);
	}

	public static int[] convertIntegers(Set<Integer> integers) {
		int[] ret = new int[integers.size()];
		int count = 0;
		for (Integer i : integers) {
			ret[count++] = i;
		}
		return ret;
	}

	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		if ((lastNode != null && root.val == lastNode.val)) {
			//相等的情况
			count++;
		} else {
			count = 1;
		}
		if (count > currentModeCount) {
			currentModeCount = count;
			record.clear();
			record.add(root.val);
		} else if (count == currentModeCount) {
			record.add(root.val);
		}
		lastNode = root;
		traverse(root.right);
	}
}
