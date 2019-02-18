package ppp;

public class FlipEquivlantBinaryTrees {

	//[1,2,3,4,5,6,null,null,null,7,8]
	//[1,3,2,null,6,4,5,null,null,null,null,8,7]
	public static void main(String[] args) {
		TreeNode tree1 = TreeNode.createTreeByArr(new int[]{1, 2, 3, 4, 5, 6, -1, -1, -1, 7, 8});
		TreeNode tree2 = TreeNode
			.createTreeByArr(new int[]{1, 3, 2, -1, 6, 4, 5, -1, -1, -1, -1, 8, 7});
		FlipEquivlantBinaryTrees flipEquivlantBinaryTrees = new FlipEquivlantBinaryTrees();
		boolean res = flipEquivlantBinaryTrees.flipEquiv(tree1, tree2);
	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (nodeEquals(root1, root2)) {
			return findEquivChild(root1, root2);
		} else {
			return false;
		}
	}

	public boolean findEquivChild(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (nodeEquals(root1.left, root2.left) && nodeEquals(root1.right, root2.right)) {
			return findEquivChild(root1.left, root2.left) && findEquivChild(root1.right,
				root2.right);
		}
		if (nodeEquals(root1.left, root2.right) && nodeEquals(root1.right, root2.left)) {
			return findEquivChild(root1.left, root2.right) && findEquivChild(root1.right,
				root2.left);
		}
		return false;
	}

	public boolean nodeEquals(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null && node1.val == node2.val) {
			return true;
		}
		return false;
	}

}
