package leetcode;

public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode sen = new ListNode(1);
        sen.next = head;
        ListNode pre = sen;
        ListNode cur = head;
        while (cur!=null){
            if (cur.val==val){
                pre.next = cur.next;
                break;
            }

            pre = cur;
            cur = cur.next;
        }

        return sen.next;
    }
}
