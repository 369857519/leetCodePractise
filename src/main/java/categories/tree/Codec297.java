package categories.tree;

import Utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class Codec297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int size = getLevel(root);
        String[] recordList = new String[(int) (Math.pow(2, size) - 1)];
        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);
        int count = 0;
        while (count <= size) {
            for (int i = 0; i <= count * 2 + 1; i++) {
                TreeNode cur = list.pollFirst();
                if (cur == null) {
                    recordList[i] = "null";
                    list.addLast(null);
                    list.addLast(null);
                } else {
                    recordList[i] = String.valueOf(cur.val);
                    list.addLast(cur.left);
                    list.addLast(cur.right);
                }

            }
            count++;
        }
        return "[" + String.join(",", recordList) + "]";
    }

    public int getLevel(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getLevel(root.left), getLevel(root.right)) + 1;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] recordArr = data.split(",");
        ArrayList<TreeNode> recordList = new ArrayList();
        for (int i = 0; i < recordArr.length; i++) {
            TreeNode curTr = null;
            if (recordArr[i] != "null") {
                curTr = new TreeNode(Integer.parseInt(recordArr[i]));
            }
            recordList.add(curTr);
        }
        for (int i = 0; i < recordList.size() / 2; i++) {
            recordList.get(i).left = recordList.get(i * 2 + 1);
            recordList.get(i).right = recordList.get(i * 2 + 2);
        }
        return recordList.get(0);

    }

}
