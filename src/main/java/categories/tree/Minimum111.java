package categories.tree;

import Utils.TreeNode;

public class Minimum111 {

	public static void main(String[] args) {
		Minimum111 minimum111 = new Minimum111();
		int res = minimum111.minDepth(TreeNode.createTreeByArr(new int[]{3,9,20,-1,-1,15,7}));
	}

	public int minDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}
		//都为空的情况下
		if (null == root.left && null == root.right) {
			return 1;
		}
		//有一个为空的情况下
		if(null==root.left||null==root.right){
			return (root.left==null?minDepth(root.right):minDepth(root.left))+1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
}
