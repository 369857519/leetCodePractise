package algorithm.categories.tree;

import algorithm.Utils.TreeNode;

/**
 * Created by 祁连山 on 2019/4/20.
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if(null==root)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
