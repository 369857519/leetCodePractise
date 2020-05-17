package algorithm.ppp;

import algorithm.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
	public static void main(String[] args) {
		TreeNode tree=TreeNode.createTreeByArr(new int[]{1});
		CBTInserter cbtInserter=new CBTInserter(tree);
		int i=cbtInserter.insert(2);
		TreeNode tn=cbtInserter.get_root();
	}
	public TreeNode treeNode;

	public CBTInserter(TreeNode root) {
		treeNode=root;
	}

	public int insert(int v) {
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(treeNode);
		while(!queue.isEmpty()){
			TreeNode currentAccess=queue.poll();
			if(currentAccess.left!=null){
				queue.offer(currentAccess.left);
			}else{
				currentAccess.left=new TreeNode(v);
				return currentAccess.val;
			}
			if(currentAccess.right!=null){
				queue.offer(currentAccess.right);
			}else{
				currentAccess.right=new TreeNode(v);
				return currentAccess.val;
			}
		}
		return treeNode.val;
	}

	public TreeNode get_root() {
		return treeNode;
	}

}
