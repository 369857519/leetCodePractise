package Algorithm.categories.tree;

import Algorithm.Utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class Codec297 {

    public static void main(String[] args) {
        Codec297 codec297 = new Codec297();
        TreeNode treeNode = codec297.deserialize("[1,3,null,null,4]");
        //        testNode = codec297.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        String str = codec297.serialize(treeNode);
        treeNode = codec297.deserialize("[1]");
        str=codec297.serialize(treeNode);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int size = getLevel(root);
        String[] recordList = new String[(int) (Math.pow(2, size) - 1)];
        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);
        int count = 1;
        while (count <= recordList.length) {
            for (int i = count; i < count * 2; i++) {
                int realIndex = i - 1;
                TreeNode cur = list.pollFirst();
                if (cur == null) {
                    recordList[realIndex] = "null";
                    list.addLast(null);
                    list.addLast(null);
                } else {
                    recordList[realIndex] = String.valueOf(cur.val);
                    list.addLast(cur.left);
                    list.addLast(cur.right);
                }

            }
            count *= 2;
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
        if(data.length()==0){
            return null;
        }
        String[] recordArr = data.split(",");
        ArrayList<TreeNode> recordList = new ArrayList();
        for (int i = 0; i < recordArr.length; i++) {
            TreeNode curTr = null;
            if (!"null".equals(recordArr[i])) {
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
