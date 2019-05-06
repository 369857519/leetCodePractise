package categories.tree;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/4/21.
 */
public class BalancedTree110 {
    public static void main(String[] args) {
        TreeNode tr=TreeNode.createTreeByArr(new int[]{1,-1,2,-1,3});
        BalancedTree110 balancedTree110=new BalancedTree110();
        boolean res=balancedTree110.isBalanced(tr);
    }
    public boolean isBalanced(TreeNode root) {
        if(null==root)return true;
        boolean rootBalanced=true;
        if(Math.abs(height(root.left)-height(root.right))>1){
            rootBalanced=false;
        }
        return isBalanced(root.left)&&isBalanced(root.right)&&rootBalanced;
    }
    Map<TreeNode,Integer> heightRecord=new HashMap();
    public int height(TreeNode root){
        if(null==root)return 0;
        if(heightRecord.getOrDefault(root,0).equals(0)){
            heightRecord.put(root,Math.max(height(root.left),height(root.right))+1);
        }
        return heightRecord.get(root);
    }
}
