package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        AddTwoNumbersII addTwoNumbersII=new AddTwoNumbersII();
        addTwoNumbersII.addTwoNumbers(ListNode.createListByArr(new int[]{0}),ListNode.createListByArr(new int[]{7,3}));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1=getLength(l1);
        int length2=getLength(l2);
        if(length1>length2){
            l2=addZero(l2,length1-length2+1);
            l1=addZero(l1,1);
        }else if(length1<length2){
            l1=addZero(l1,length1-length2+1);
            l2=addZero(l2,1);
        }else{
            l1=addZero(l1,1);
            l2=addZero(l2,1);
        }
        ListNode res=addListNode(l1,l2);
        if(res.val==0){
            return res.next;
        }
        return res;
    }

    public ListNode addListNode(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return null;
        }else{
            ListNode lastNode=addListNode(l1.next,l2.next);
            int carry=0;
            if(lastNode!=null&&lastNode.val>=10){
                carry=lastNode.val/10;
                lastNode.val=lastNode.val%10;
            }
            ListNode thisNode=new ListNode(l1.val+l2.val+carry);
            thisNode.next=lastNode;
            return thisNode;
        }
    }
    public int getLength(ListNode node){
        int length=0;
        while(node!=null){
            node=node.next;
            length++;
        }
        return length;
    }

    public ListNode addZero(ListNode node,int count){
        while(count>0){
            ListNode temp=new ListNode(0);
            temp.next=node;
            node=temp;
            count--;
        }
        return node;
    }
}
