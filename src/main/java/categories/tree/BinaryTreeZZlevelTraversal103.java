package categories.tree;

import Utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZZlevelTraversal103 {

	public static void main(String[] args) {
		BinaryTreeZZlevelTraversal103 binaryTreeZZlevelTraversal103 = new BinaryTreeZZlevelTraversal103();
		List<List<Integer>> arr = binaryTreeZZlevelTraversal103
			.zigzagLevelOrder(TreeNode.createTreeByArr(new int[]{3, 9, 20, -1, -1, 15, 7}));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<>();
		if (root == null) {
			return resList;
		}
		ArrayList<TreeNode> nextLevelNodes = new ArrayList<>();
		LinkedList<TreeNode> treeNodes = new LinkedList<>();
		treeNodes.add(root);
		int flag = 0;
		while (!treeNodes.isEmpty()) {
			List<Integer> levelListValues = new ArrayList<>();
			while (!treeNodes.isEmpty()) {
				TreeNode treeNode = treeNodes.poll();
				if (treeNode != null) {
					levelListValues.add(treeNode.val);
					if (treeNode.left != null) {
						nextLevelNodes.add(treeNode.left);
					}
					if (treeNode.right != null) {
						nextLevelNodes.add(treeNode.right);
					}
				}
			}
			if (flag % 2 == 1) {
				Collections.reverse(levelListValues);
			}
			resList.add(levelListValues);
			treeNodes.addAll(nextLevelNodes);
			nextLevelNodes.clear();
			flag++;
		}
		return resList;
	}
}

