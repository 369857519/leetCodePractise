package categories.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/4/13.
 */
public class CLRP138 {


    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        CLRP138 clrp138 = new CLRP138();
        clrp138.copyRandomList(node0);
        clrp138.copyRandomList(new Node(1));
    }

    public Node copyRandomList(Node head) {
        Node newHead = new Node(head.val);
        Node ptr = head;
        Node newPtr = newHead;
        newPtr.next = ptr.next;
        ptr.next = newPtr;
        ptr = newPtr.next;

        while (ptr != null) {
            newPtr = new Node(ptr.val);
            newPtr.next = ptr.next;
            ptr.next = newPtr;
            ptr = newPtr.next;

        }

        ptr = head;
        newPtr = newHead;
        while (ptr != null) {
            if (ptr.random != null) {
                newPtr.random = ptr.random.next;
            }
            ptr = newPtr.next;
            if (ptr == null) {
                break;
            }
            newPtr = ptr.next;
        }
        ptr = head;
        newPtr = newHead;
        while (ptr != null) {
            ptr.next = newPtr.next;
            ptr = ptr.next;
            if (ptr == null) {
                newPtr.next=null;
                break;
            }
            newPtr.next = ptr.next;
            newPtr = newPtr.next;
        }

        return newHead;
    }

    public Node copyRandomListWithMap(Node head) {
        if (head == null) {
            return head;
        }
        Node newHead = new Node(head.val);
        Node newPtr = newHead;
        Node ptr = head;

        Map<Node, Integer> map = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();
        int index = 0;
        map.put(ptr, index);
        newMap.put(index, newHead);
        ptr = ptr.next;

        while (ptr != null) {
            index++;
            map.put(ptr, index);
            newPtr.next = new Node(ptr.val);
            newPtr = newPtr.next;
            newMap.put(index, newPtr);
            ptr = ptr.next;
        }

        ptr = head;
        newPtr = newHead;
        while (ptr != null) {
            newPtr.random = newMap.get(map.get(ptr.random));
            ptr = ptr.next;
            newPtr = newPtr.next;
        }
        return newHead;
    }
}
