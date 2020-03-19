package categories.tree;

import Utils.TreeNode;

public class FlatternTree114 {

    public static void main(String[] args) {
        FlatternTree114 flatternTree114 = new FlatternTree114();
        flatternTree114.flatten(TreeNode.createTreeByArr(new int[]{1, 2, 5, 3, 4, -1, 6}));
        flatternTree114.flatten(TreeNode.createTreeByArr(new int[]{1, 2}));
        flatternTree114.flatten(TreeNode.createTreeByArr(new int[]{1, -1, 2, 3}));
    }

    public void flatten(TreeNode root) {
        TreeNode res = traverse(root);
    }

    public TreeNode traverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = traverse(node.left);
        if (left != null) {
            TreeNode leftHead = left;
            TreeNode leftTail = left;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }
            leftTail.right = node.right;
            node.right = leftHead;
            node.left = null;
        }
        traverse(node.right);
        return node;
    }
}
