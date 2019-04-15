package categories.graph;

import Utils.Node;

import java.util.*;

/**
 * Created by 祁连山 on 2019/4/13.
 */
public class CG133 {
    public static void main(String[] args) {
        Node node1=new Node(1,new ArrayList<>());
        Node node2=new Node(2,new ArrayList<>());
        Node node3=new Node(3,new ArrayList<>());
        Node node4=new Node(4,new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        CG133 cg133=new CG133();
        Node newNode=cg133.cloneGraph(node1);
    }
    public Node cloneGraph(Node node) {
        return traverse(node,new Node(node.val,new ArrayList<>()));
    }
    Map<Node,Node> oldNew= new HashMap<>();
    public Node traverse(Node node,Node newNode){
        oldNew.put(node,newNode);
        for(Node nextNode:node.neighbors){
            //看一下在map里对应的节点有没有，如果没有就new一个
            if(oldNew.get(nextNode)==null) {
                newNode.neighbors.add(traverse(nextNode, new Node(nextNode.val,new ArrayList<>())));
            }else{
                newNode.neighbors.add(oldNew.get(nextNode));
            }
        }
        return newNode;
    }
}
