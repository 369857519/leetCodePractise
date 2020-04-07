package categories.tree;

import Utils.ListNode;
import Utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 祁连山 on 2019/4/20.
 */
public class SymTree101 {
    public boolean isSymmetric(TreeNode root) {
        "fdsfd".split(",");
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
