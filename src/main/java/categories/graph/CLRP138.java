package categories.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 祁连山 on 2019/4/13.
 */
public class CLRP138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        Node itr = head;
        Node newHead = new Node(head.val, null, null);
        Node newItr = newHead;
        List<Node> oldArr = new ArrayList<>();
        List<Node> newArr = new ArrayList<>();
        while (itr != null) {
            oldArr.add(itr);
            newArr.add(newItr);
            itr = itr.next;
            newItr.next = new Node(itr.val, null, null);
            newItr = newItr.next;
        }
        for(int i=0;i<oldArr.size();i++){
            int randomIndex=oldArr.indexOf(oldArr.get(i).random);
            newArr.get(i).random=newArr.get(randomIndex);
        }
        return newHead;
    }
}
