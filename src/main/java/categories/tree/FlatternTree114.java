package categories.tree;

import Utils.TreeNode;
import java.util.Stack;

public class FlatternTree114 {

    public static void main(String[] args) {
        FlatternTree114 flatternTree114 = new FlatternTree114();
        flatternTree114.flatten(TreeNode.createTreeByArr(new int[]{1, 2, 5, 3, 4, -1, 6}));
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        pushStack(root, stk);
        while (!stk.isEmpty()) {
            TreeNode curNode = stk.pop();
            boolean needInsert=false;
            if (curNode.right != null) {
                //进行一次嫁接
                pushStack(curNode.right, stk);
                if (curNode.left != null) {
                    //嫁接
                    System.out.println("insert" + curNode.val);
                    needInsert=true;
                }
            }
            if(needInsert){

            }else{

            }
            System.out.println(curNode.val);
        }
    }

    public void pushStack(TreeNode root, Stack<TreeNode> stk) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }
}
