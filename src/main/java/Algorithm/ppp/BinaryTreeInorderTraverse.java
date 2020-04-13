package Algorithm.ppp;

import Algorithm.Utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraverse {

	public List<Integer> res = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return res;
		}
		if (root.left != null) {
			inorderTraversal(root.left);
		}
		res.add(root.val);
		if (root.right != null) {
			inorderTraversal(root.right);
		}

		return res;
	}
}
