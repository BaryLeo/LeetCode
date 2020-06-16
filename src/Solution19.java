import java.util.ArrayList;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode pre = new ListNode(1);
        ListNode myHead = pre;
        pre.next = head;

        int count = 1;
        while (cur!=null){
            if (count-n>0){
                pre = pre.next;
            }
            cur = cur.next;
            count++;
        }

        if (pre.next.next!=null){
            pre.next = pre.next.next;
        }else {
            pre.next = null;
        }

        return myHead.next;
    }

    public ListNode removeNthFromE(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        getLastIndex(pre,0,n-1);
        return pre.next;
    }

    public int getLastIndex(ListNode pre,int preIndex,int n){
        ListNode thisNode = pre.next;
        int thisIndex = (++preIndex);
        if (thisNode.next==null){
            //判断为该节点是尾节点
            if (n == 0){
                pre.next = null;
                return -1;
            }else {
                return thisIndex;
            }
        }

        int lastIndex = getLastIndex(thisNode,thisIndex,n);

        if (thisIndex==(lastIndex-n)){
            pre.next=thisNode.next;
        }

        return lastIndex;
    }

}
