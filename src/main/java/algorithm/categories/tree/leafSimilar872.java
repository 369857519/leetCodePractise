package algorithm.categories.tree;

import algorithm.Utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class leafSimilar872 {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = getLeaves(root1, new ArrayList<>());
		List<Integer> list2 = getLeaves(root2, new ArrayList<>());
		if(list1.size()!=list2.size()){
			return false;
		}
		for(int i=0;i<list1.size();i++){
			if(list1.get(i)!=list2.get(i)){
				return false;
			}
		}
		return true;
	}

	public List<Integer> getLeaves(TreeNode treeNode, List<Integer> leaves) {
		if (treeNode == null) {
			return null;
		}
		if (treeNode.left == null && treeNode.right == null) {
			leaves.add(treeNode.val);
		}
		getLeaves(treeNode.left, leaves);
		getLeaves(treeNode.right, leaves);
		return leaves;
	}
}
