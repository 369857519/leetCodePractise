package categories.tree;

import Utils.TreeNode;

public class InOrderPreOrderConstructTree105 {

	public static void main(String[] args) {
		InOrderPreOrderConstructTree105 inOrderPreOrderConstructTree105 = new InOrderPreOrderConstructTree105();
		inOrderPreOrderConstructTree105
			.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		inOrderPreOrderConstructTree105.buildTree(new int[]{1, 2}, new int[]{2, 1});
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return traverse(preorder, inorder);
	}

	public TreeNode traverse(int[] preOrder, int[] inOrder) {
		if (preOrder.length == 0 || inOrder.length == 0) {
			return null;
		}
		TreeNode treeNode = new TreeNode(preOrder[0]);
		if (preOrder.length == 1) {
			return treeNode;
		}
		//找到中序的根节点位置
		int root = 0;
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == preOrder[0]) {
				root = i;
				break;
			}
		}
		int[] leftInOrder = new int[root];
		int[] leftPreOrder = new int[root];
		int[] rightInOrder = new int[inOrder.length - root - 1];
		int[] rightPreOrder = new int[inOrder.length - root - 1];
		for (int i = 0; i < inOrder.length; i++) {
			if (i < root) {
				leftInOrder[i] = inOrder[i];
			}
			if (i > root) {
				rightInOrder[i - root - 1] = inOrder[i];
			}
			if (i > 0 && i <= root) {
				leftPreOrder[i - 1] = preOrder[i];
			}
			if (i > root) {
				rightPreOrder[i - root - 1] = preOrder[i];
			}
		}
		treeNode.left = traverse(leftPreOrder, leftInOrder);
		treeNode.right = traverse(rightPreOrder, rightInOrder);
		return treeNode;
	}
}
