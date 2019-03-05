package ppp;

import Utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		TreeNode root =TreeNode.createTreeByArr(new int[]{2,1,3});

		FindBottomLeftTreeValue findBottomLeftTreeValue=new FindBottomLeftTreeValue();
		findBottomLeftTreeValue.findBottomLeftValue(root);

	}

	public int findBottomLeftValue(TreeNode root) {
		return traverseTree(root);
	}

	public int traverseTree(TreeNode root) {
		Queue<TreeNode> treeNodesOfOneLevel = new LinkedList<>();
		int value = root.val;
		treeNodesOfOneLevel.offer(root);
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
				value = nextLevel.peek().val;
				while (!nextLevel.isEmpty()) {
					treeNodesOfOneLevel.offer(nextLevel.poll());
				}
			}
		}
		return value;
	}
}
