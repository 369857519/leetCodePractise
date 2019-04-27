package categories.tree;

import Utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102 107 429
public class LevelOrder102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if (null == root) {
			return res;
		} else {
			nodeQueue.offer(root);
		}
		while (!nodeQueue.isEmpty()) {
			for (TreeNode tr : nodeQueue) {
				temp.add(tr.val);
			}
			Collections.reverse(temp);
			res.add(new ArrayList<>(temp));
			for (int i = 0; i < temp.size(); i++) {
				TreeNode current = nodeQueue.poll();
				if (current.right != null) {
					nodeQueue.offer(current.right);
				}
				if (current.left != null) {
					nodeQueue.offer(current.left);
				}
			}
			temp.clear();
		}
		return res;
	}
}
