package categories.tree;

import Utils.TreeNode;

public class InOrderPreOrderConstructTree105 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		preorder = [3,9,20,15,7]
//		inorder = [9,3,15,20,7]
		int inOrderRootIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (preorder[0] == inorder[i]) {
				inOrderRootIndex = i;
			}
		}
		return  buildTree(0, inOrderRootIndex, preorder, inorder);
	}

	public TreeNode buildTree(int preRoot, int inRoot, int[] preorder, int[] inorder) {
		TreeNode treeNode = new TreeNode(preorder[preRoot]);
		int root = preorder[preRoot];
		//左节点
		if (preorder[preRoot + 1] == inorder[inRoot - 1]) {
			treeNode.left = buildTree(+1, inRoot - 1, preorder, inorder);
		}


		return treeNode;
	}
}
