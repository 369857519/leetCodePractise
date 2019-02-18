package ppp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTree {

	public List<Integer> largestValues(TreeNode root) {
		if (null == root) {
			return new ArrayList<>();
		}
		return traverseTree(root);
	}

	public List<Integer> traverseTree(TreeNode root) {
		Queue<TreeNode> treeNodesOfOneLevel = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		int value = root.val;
		treeNodesOfOneLevel.offer(root);
		res.add(value);

		while (!treeNodesOfOneLevel.isEmpty()) {
			Queue<TreeNode> nextLevel = new LinkedList<>();
			while (!treeNodesOfOneLevel.isEmpty()) {
				TreeNode currentNode = treeNodesOfOneLevel.poll();
				if (currentNode.left != null) {
					nextLevel.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.offer(currentNode.right);
				}
			}
			if (!nextLevel.isEmpty()) {
				int max = Integer.MIN_VALUE;
				while (!nextLevel.isEmpty()) {
					TreeNode node = nextLevel.poll();
					if (node.val > max) {
						max = node.val;
					}
					treeNodesOfOneLevel.offer(node);
				}
				res.add(max);
			}
		}
		return res;
	}
}
