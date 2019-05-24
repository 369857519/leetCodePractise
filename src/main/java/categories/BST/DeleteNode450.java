package categories.BST;

import Utils.TreeNode;

public class DeleteNode450 {

	public static void main(String[] args) {
		TreeNode res = new DeleteNode450()
			.deleteNode(TreeNode.createTreeByArr(new int[]{2, 1}), 2);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key == root.val) {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			traverse(root, null, true, key);
			root.val = prevVal;
		} else {
			traverse(root, null, true, key);
		}
		return root;
	}

	/**
	 * @description:
	 * @param: leftOrRight true->left false right
	 * @return:
	 * @author: Qi Lianshan
	 */
	TreeNode prev = null;
	TreeNode prevParent = null;
	int prevVal = 0;
	boolean prevLeftOrRight = false;

	public void traverse(TreeNode root, TreeNode parent, boolean leftOrRight, int key) {
		if (root == null) {
			return;
		}
		//删除某个元素，递归与面的元素换位置，直到没有子节点即可
		traverse(root.left, root, true, key);
		if (root.val == key) {
			//如果是跟跟节点，则删除它之前的那个节点
			if (parent == null) {
				remove(prev, prevParent, prevLeftOrRight);
			} else {
				remove(root, parent, leftOrRight);
			}
			return;
		}
		prev = root;
		prevParent = parent;
		prevVal = root.val;
		prevLeftOrRight = prevLeftOrRight;
		traverse(root.right, root, false, key);
	}

	public Integer remove(TreeNode root, TreeNode parent, boolean leftOrRight) {
		int res = 0;
		//这个节点有没有子节点
		if (root.left == null && root.right == null) {
			if (leftOrRight) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			res = root.val;
		} else if (root.left == null) {
			if (leftOrRight) {
				parent.left = root.right;
			} else {
				parent.right = root.right;
			}
			res = root.right.val;
		} else if (root.right == null) {
			if (leftOrRight) {
				parent.left = root.left;
			} else {
				parent.right = root.right;
			}
			res = root.left.val;
		} else {
			//都不为空,如果是左边节点，则替换root和右节点的值，然后递归删除右节点。反之亦然
			if (leftOrRight) {
				root.val = root.right.val;
				res = remove(root.right, root, false);
			} else {
				root.val = root.left.val;
				res = remove(root.left, root, true);
			}
		}
		return res;
	}
}
