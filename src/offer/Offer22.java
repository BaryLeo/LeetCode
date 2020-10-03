package leetcode;

public class Offer22 {
    ListNode res;

    public ListNode getKthFromEnd(ListNode head, int k) {
        find(head,k);
        return res;
    }

    public int find(ListNode head,int k){
        if (head==null){
            return 0;
        }

        int cur = find(head.next,k)+1;

        if (cur==k){
            res = head;
        }

        return cur;
    }

}
