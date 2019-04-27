package categories.tree;

import Utils.TreeNode;

/**
 * Created by 祁连山 on 2019/4/20.
 */
public class SymTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(null==root){
            return true;
        }
        return isFlipSameTree(root.left,root.right);
    }
    public boolean isFlipSameTree(TreeNode p, TreeNode q) {
        if (null == p || null == q) return p == q;
        return p.val == q.val && isFlipSameTree(p.left, q.right) && isFlipSameTree(p.right, q.left);
    }
}
