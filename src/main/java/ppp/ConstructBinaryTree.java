package ppp;

public class ConstructBinaryTree {

	//Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
	//Output: [1,2,3,4,5,6,7]
	public static void main(String[] args) {
		ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
		constructBinaryTree.constructFromPrePost(new int[]{2, 1},
			new int[]{1, 2});
//		constructBinaryTree.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7},
//			new int[]{4, 5, 2, 6, 7, 3, 1});
	}

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		TreeNode node = buildNode(0, pre.length - 1, pre, post);
		return node;
	}

	public TreeNode buildNode(int preRootIndex, int postRootIndex, int[] pre, int[] post) {

		if (postRootIndex < 0 || preRootIndex >= pre.length) {
			return null;
		}
		TreeNode currentNode = new TreeNode(pre[preRootIndex]);

		int currentNodeLeft = preRootIndex + 1;
		int currentNodeRight = postRootIndex - 1;
		boolean rightExist = currentNodeLeft < pre.length;
		boolean leftExist = currentNodeRight >= 0;
		if(rightExist&&leftExist) {
			if (pre[currentNodeLeft] != post[currentNodeRight]) {
				//找到后序中左节点的位置
				int postLeft = currentNodeRight;
				while (postLeft >= 0 && post[postLeft] != pre[currentNodeLeft]) {
					--postLeft;
				}
				currentNode.left = buildNode(currentNodeLeft, postLeft, pre, post);
				//找到前序中右节点的位置
				int preRight = currentNodeLeft;
				while (preRight < pre.length && pre[preRight] != post[currentNodeRight]) {
					++preRight;
				}
				currentNode.right = buildNode(preRight, currentNodeRight, pre, post);
			} else {
				//相等的情况
				currentNode.right = buildNode(currentNodeLeft, currentNodeRight, pre, post);
			}
		}


		return currentNode;
	}
}
