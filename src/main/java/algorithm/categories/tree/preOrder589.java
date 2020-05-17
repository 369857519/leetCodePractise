package algorithm.categories.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 祁连山 on 2019/4/20.
 */
public class preOrder589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        if(null==root){
            return list;
        }
        list.add(root.val);
        if(null==root.children||root.children.size()==0){
            return list;
        }
        for(Node node:root.children){
            list.addAll(preorder(node));
        }
        return list;
    }
}
