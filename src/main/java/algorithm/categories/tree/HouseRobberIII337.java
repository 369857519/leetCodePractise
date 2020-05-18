package algorithm.categories.tree;

import algorithm.Utils.TreeNode;
import java.util.HashMap;

public class HouseRobberIII337 {


    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> integerHashMap = new HashMap<>();
        traverse(root, integerHashMap);
        return integerHashMap.get(root);
    }

    public void traverse(TreeNode treeNode, HashMap<TreeNode, Integer> mapHashMap) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.right == null && treeNode.right == null) {
            mapHashMap.put(treeNode, treeNode.val);
        }
        traverse(treeNode.left,mapHashMap);
        traverse(treeNode.right,mapHashMap);
        int chooseCurrent = treeNode.val;
        int notChooseCurrent = 0;
        if (treeNode.left != null) {
            int leftLeft = treeNode.left.left == null ? 0 : mapHashMap.getOrDefault(treeNode.left.left,0);
            int leftRight = treeNode.left.right == null ? 0 : mapHashMap.getOrDefault(treeNode.left.right,0);
            chooseCurrent += leftLeft + leftRight;
            notChooseCurrent += mapHashMap.get(treeNode.left);
        }
        if (treeNode.right != null) {
            int rightLeft = treeNode.right.left == null ? 0 : mapHashMap.getOrDefault(treeNode.right.left,0);
            int rightRight =
                treeNode.right.right == null ? 0 : mapHashMap.get(treeNode.right.right);
            chooseCurrent += rightLeft + rightRight;
            notChooseCurrent += mapHashMap.get(treeNode.right);
        }
        mapHashMap.put(treeNode, Math.max(chooseCurrent, notChooseCurrent));
        return;
    }

}
