package Algorithm.categories.tree;

import Algorithm.Utils.TreeNode;

/**
 * Created by 祁连山 on 2019/4/20.
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p || null == q) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
