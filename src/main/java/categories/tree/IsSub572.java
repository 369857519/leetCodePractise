package categories.tree;

import Utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class IsSub572 {

	public static void main(String[] args) {
		TreeNode s = TreeNode.createTreeByArr(new int[]{1,1});
		TreeNode t = TreeNode.createTreeByArr(new int[]{1});
		IsSub572 isSub572 = new IsSub572();
		boolean res=isSub572.isSubtree(s, t);
	}

	public boolean checkSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val == t.val) {
			return checkSameTree(s.left, t.left) && checkSameTree(s.right, t.right);
		}
		return false;
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		Queue<TreeNode> queue=new LinkedList<>();
		if(null!=s){
			queue.offer(s);
		}
		while(!queue.isEmpty()){
			TreeNode treeNode=queue.poll();
			if(null!=treeNode.left)queue.offer(treeNode.left);
			if(null!=treeNode.right)queue.offer(treeNode.right);
			if(checkSameTree(treeNode,t)){
				return true;
			}
		}
		return false;
	}
}
