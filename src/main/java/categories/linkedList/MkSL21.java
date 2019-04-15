package categories.linkedList;


import java.util.*;

/**
 * Created by 祁连山 on 2019/4/14.
 */



public class MkSL21 {


    public static void main(String[] args) {
        MkSL21 mkSL21=new MkSL21();
        ListNode[] lists=new ListNode[]{new ListNode(1)};
        mkSL21.mergeKLists(lists);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        Queue<ListNode> queue=new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        for(ListNode ln:lists){
            if(ln!=null){
                queue.offer(ln);
            }
        }
        ListNode outerPtr=queue.peek();
        ListNode res=queue.peek();
        while(!queue.isEmpty()){
            ListNode ptr=queue.poll();
            if(ptr.next!=null) {
                queue.offer(ptr.next);
            }
            if(outerPtr!=ptr){
                outerPtr.next=ptr;
                outerPtr=ptr;
            }
        }
        return res;
    }
}
