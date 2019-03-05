package ppp;

import Utils.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SSWATDN865 {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTreeByArr(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
		SSWATDN865 sswatdn865 = new SSWATDN865();
		TreeNode tr = sswatdn865.subtreeWithAllDeepest(root);
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		Map<TreeNode, TreeNode> childParent = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> currentLevel = new LinkedList();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode treeNode = queue.poll();
				currentLevel.add(treeNode);
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
					childParent.put(treeNode.left, treeNode);
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
					childParent.put(treeNode.right, treeNode);
				}
			}
			if (!queue.isEmpty()) {
				//如果不是最后一层，就清空
				currentLevel.clear();
			}
		}
		HashSet<TreeNode> treeNodeSet = new HashSet<>();
		while (currentLevel.size() != 1) {
			TreeNode treeNode = currentLevel.poll();
			TreeNode treeNodesParent = childParent.get(treeNode);
			if (!treeNodeSet.contains(treeNodesParent)) {
				currentLevel.offer(treeNodesParent);
			}
			treeNodeSet.add(treeNodesParent);
		}
		return (TreeNode) currentLevel.toArray()[0];
	}
}
