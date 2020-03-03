package categories.linkedList;

import com.sun.java.util.jar.pack.ConstantPool.Index;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        public Node(int _val) {
            val = _val;
        }
    }

    public Node copyRandomList(Node head) {
        Node newHead=new Node(head.val);
        Node newPtr=newHead;
        Node ptr=head;
        Map<Node,Integer> map=new HashMap<>();
        Map<Integer,Node> newMap=new HashMap<>();
        int index=0;
        map.put(newPtr,index);
        newMap.put(index,newHead);
        while(ptr!=null){
            ptr=ptr.next;
            index++;
            map.put(newPtr,index);
            newPtr.next=new Node(ptr.val);
            newPtr=newPtr.next;
        }

        ptr=head;
        newPtr=newHead;
        while(ptr!=null){
            newPtr.random=newMap.get(map.get(ptr.random));
        }
        return newHead;
    }
}
