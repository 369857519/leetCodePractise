package ppp;

public class ConstructMaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode cr=c(0,nums.length,nums);
		return cr;
	}

	private TreeNode c(int start,int end,int[] nums){
		int index=start;
		int current=nums[start];
		for(int i=start;i<end;i++){
			if(nums[i]>current){
				current=nums[i];
				index=i;
			}
		}
		TreeNode currentRoot=new TreeNode(current);
		if(index>start){
			currentRoot.left=c(start,index,nums);
		}
		if(index<end-1){
			currentRoot.right=c(index+1,end,nums);
		}
		return currentRoot;
	}
}

