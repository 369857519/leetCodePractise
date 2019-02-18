package ppp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTreeByArr(int[] arr) {
		TreeNode[] treeNodes = new TreeNode[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				treeNodes[i] = new TreeNode(arr[i]);
			} else {
				treeNodes[i] = null;
			}
		}
		Queue<TreeNode> level = new LinkedList<>();
		level.offer(treeNodes[0]);
		int pivot = 0;
		while (pivot < treeNodes.length) {
			TreeNode currentNode = level.poll();
			if (++pivot >= treeNodes.length) {
				break;
			}
			currentNode.left = treeNodes[pivot];
			if (currentNode.left != null) {
				level.offer(currentNode.left);
			}
			if (++pivot >= treeNodes.length) {
				break;
			}
			currentNode.right = treeNodes[pivot];
			if (currentNode.right != null) {
				level.offer(currentNode.right);
			}
		}
		return treeNodes[0];
	}

}
