package Algorithm.categories.tree;

import Algorithm.Utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelO107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (null == root) {
			return res;
		} else {
			nodeQueue.offer(root);
		}
		while (!nodeQueue.isEmpty()) {
			res.add(0,new ArrayList());
			for(TreeNode tr:nodeQueue){
				res.get(0).add(tr.val);
			}
			for (int i = 0; i < res.get(0).size(); i++) {
				TreeNode current = nodeQueue.poll();
				if (current.left != null) {
					nodeQueue.offer(current.left);
				}
				if (current.right != null) {
					nodeQueue.offer(current.right);
				}
			}
		}
		return res;
	}
}
