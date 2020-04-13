package Algorithm.categories.tree;

import Algorithm.Utils.TreeNode;
import java.util.Arrays;

public class InOrderPreOrderConstructTree105 {

    public static void main(String[] args) {
        InOrderPreOrderConstructTree105 inOrderPreOrderConstructTree105 = new InOrderPreOrderConstructTree105();
        inOrderPreOrderConstructTree105
            .buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        inOrderPreOrderConstructTree105.buildTree(new int[]{1, 2}, new int[]{2, 1});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1 || inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootVal = preorder[0];
        int leftLen = 0;
        while (inorder[leftLen] != rootVal) {
            leftLen++;
        }
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, leftLen + 1);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, leftLen);
        int[] preorderRight = Arrays.copyOfRange(preorder, leftLen + 1, preorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, leftLen + 1, inorder.length);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }
}

