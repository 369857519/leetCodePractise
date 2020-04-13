package Algorithm.categories.tree;

import Algorithm.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 祁连山 on 2019/5/5.
 */
public class PathSumII113 {
    public static void main(String[] args) {
        TreeNode treeNode=TreeNode.createTreeByArr(new int[]{-2,-1,-3});
        PathSumII113 pathSumII113=new PathSumII113();
        pathSumII113.pathSum(treeNode,22);
    }
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> list=new ArrayList<>();
            pathTraverse(list,new ArrayList<>(),root,0,sum);
            return list;
        }
        public List<List<Integer>> pathTraverse(List<List<Integer>> list,List<Integer> recordList,TreeNode node,int currentVal,int sum){
            if(node==null){
                return list;
            }
            recordList.add(node.val);
            currentVal+=node.val;
            if(currentVal==sum&&node.left==null&&node.right==null){
                list.add(new ArrayList<>(recordList));
                recordList.remove(recordList.size()-1);
            }else{
                pathTraverse(list,recordList,node.left,currentVal,sum);
                pathTraverse(list,recordList,node.right,currentVal,sum);
                recordList.remove(recordList.size()-1);
            }
            return list;
        }
}
