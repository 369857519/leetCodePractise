package ppp;

import Utils.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

	Map<Integer, List<TreeNode>> memo = new HashMap();

	public List<TreeNode> allPossibleFBT(int N) {
		if (!memo.containsKey(N)) {
			List<TreeNode> ans = new LinkedList<TreeNode>();
			if (N == 1) {
				ans.add(new TreeNode(0));
			} else if (N % 2 == 1) {
				for (int x = 0; x < N; ++x) {
					int y = N - 1 - x;
					//对于每一种可能的情况，遍历，并放入缓存
					for (TreeNode left : allPossibleFBT(x)) {
						for (TreeNode right : allPossibleFBT(y)) {
							TreeNode bns = new TreeNode(0);
							bns.left = left;
							bns.right = right;
							ans.add(bns);
						}
					}
				}
			}
			//在N个节点的情况下，全部遍历以后，存入Map
			memo.put(N, ans);
		}
		return memo.get(N);
	}
}
