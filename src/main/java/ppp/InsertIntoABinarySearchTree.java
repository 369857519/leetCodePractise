package ppp;


public class InsertIntoABinarySearchTree {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		return insert(root,val);
	}

	public TreeNode insert(TreeNode node,int val){
		if(val>node.val){
			if(node.right==null){
				node.right=new TreeNode(val);
			}else{
				insert(node.right,val);
			}
		}else{
			if(node.left==null){
				node.left=new TreeNode(val);
			}else{
				insert(node.left,val);
			}
		}
		return node;
	}
}


