package categories.tree;

import Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class PathSumIII437NR {

    public static void main(String[] args) {
        TreeNode testNode = TreeNode
            .createTreeByArr(new int[]{10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1});

        PathSumIII437NR pathSumIII437 = new PathSumIII437NR();
        int count = pathSumIII437.pathSum(testNode, 8);

        testNode = TreeNode.createTreeByArr(new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1});
        count = pathSumIII437.pathSum(testNode, 22);

        testNode = TreeNode.createTreeByArr(new int[]{1});
        count = pathSumIII437.pathSum(testNode, 0);
    }

    private int target = 0;

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return traverse(root, 0, map);
    }

    //返回这棵树中有的个数
    //map: key之前的数字的和 value有多少种路径能到这个位置，每到一次都加一
    public int traverse(TreeNode node, int sum, Map<Integer, Integer> sums) {
        if (node == null) {
            return 0;
        }
        int curVal = sum += node.val;
        int res = sums.getOrDefault(sum - target, 0);
        sums.put(curVal, sums.getOrDefault(curVal, 0) + 1);
        res += traverse(node.left, curVal, sums);
        res += traverse(node.right, curVal, sums);
        sums.put(curVal, sums.get(curVal) - 1);
        return res;
    }
}
