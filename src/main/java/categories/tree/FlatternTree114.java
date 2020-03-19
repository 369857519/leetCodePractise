package categories.tree;

import Utils.TreeNode;
import java.util.Stack;

public class FlatternTree114 {

    public static void main(String[] args) {
        FlatternTree114 flatternTree114 = new FlatternTree114();
        flatternTree114.flatten(TreeNode.createTreeByArr(new int[]{1, 2, 5, 3, 4, -1, 6}));
        flatternTree114.flatten(TreeNode.createTreeByArr(new int[]{1, 2}));
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        pushStack(root, stk);
        TreeNode head = new TreeNode(0);
        TreeNode tail = head;
        while (!stk.isEmpty()) {
            TreeNode curNode = stk.pop();
            boolean needInsert = false;
            if (curNode.right != null) {
                //进行一次嫁接
                pushStack(curNode.right, stk);

            }

            if (curNode.left != null) {
                curNode.right = head.right;
                head.right = curNode;
                curNode.left = null;
            } else {
                tail.right = curNode;
                tail = curNode;
                curNode.left = null;
                curNode.right = null;
            }
            System.out.println(curNode.val);
        }
        System.out.println("finish");
    }

    public void pushStack(TreeNode root, Stack<TreeNode> stk) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }
}
