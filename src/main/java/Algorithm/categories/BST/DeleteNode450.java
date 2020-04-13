package Algorithm.categories.BST;

import Algorithm.Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DeleteNode450 {

	public static void main(String[] args) {
		TreeNode res;
		res = new DeleteNode450().deleteNode(TreeNode.createTreeByArr(new int[]{2, 1}), 2);
		res = new DeleteNode450().deleteNode(TreeNode.createTreeByArr(new int[]{0}), 0);
		res = new DeleteNode450().deleteNode(TreeNode.createTreeByArr(new int[]{10, 9, 11}), 11);
		res = new DeleteNode450()
			.deleteNode(TreeNode.createTreeByArr(new int[]{3, 1, 4, -1, 2}), 3);
		res = new DeleteNode450()
			.deleteNode(TreeNode.createTreeByArr(new int[]{5, 3, 6, 2, 4, -1, 7}), 3);
		res = new DeleteNode450()
			.deleteNode(TreeNode.createTreeByArr(new int[]{1, -1, 2}), 1);
		res = new DeleteNode450()
			.deleteNode(TreeNode.createTreeByArr(new int[]{3, 1, 4, -1, 2}), 1);

	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		traverse(root, null, key);
		if (!get) {
			return root;
		}
		TreeNode current = traverseRecord.pop();
		if (root.val == key) {
			return delete(current, childParent.get(current));
		} else {
			delete(current, childParent.get(current));
			return root;
		}
	}

	Stack<TreeNode> traverseRecord = new Stack<>();
	Map<TreeNode, TreeNode> childParent = new HashMap<>();
	boolean get = false;

	public TreeNode traverse(TreeNode node, TreeNode parent, int key) {
		if (node == null) {
			return node;
		}
		TreeNode leftRes = traverse(node.left, node, key);
		if (leftRes != null) {
			return leftRes;
		}
		traverseRecord.push(node);
		childParent.put(node, parent);
		if (node.val == key) {
			get = true;
			return node;
		}
		return traverse(node.right, node, key);
	}


	public TreeNode delete(TreeNode root, TreeNode parent) {
		boolean left = true;
		if (parent != null) {
			left = parent.left == root ? true : false;
		}
		if (root.left != null && root.right != null) {
			TreeNode lastNode = traverseRecord.pop();
			lastNode.right = root.right;
			//处理parent的关系
			root = root.left;
		} else if (root.right != null) {
			root = root.right;
		} else if (root.left != null) {
			root = root.left;
		} else {
			root = null;
		}
		if (parent != null) {
			if (left) {
				parent.left = root;
			} else {
				parent.right = root;
			}
		}
		return root;
	}

}
