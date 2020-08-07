/**
 * 24,25的解题思路一致，24的K是固定的2而已
 */
public class Solution25_24 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode myHead = new ListNode(-1);
        myHead.next = head;
        ListNode pre = myHead;
        ListNode end = myHead;


        while (end.next!=null){
            for (int i =0;i<k&&end!=null;i++){
                    end =end.next;
            }

            if (end==null){
                //若不满足反转要求，就不进行反转，并肯定是最后一段链表
                break;
            }

            //现在的反转链表头结点为start
            ListNode start = pre.next;

            //保留下一开头节点
            ListNode next = end.next;

            //截断链表
            end.next = null;

            //断点连接反转后头结点
            pre.next = reverse(start);

            //现在的尾节点为start，连上断点
            start.next = next;

            //移动pre和end
            pre = start;
            //给end赋值pre的原因在30行附近
            end = pre;
        }

        return myHead.next;
    }

    public ListNode reverse(ListNode head){
        //进行反转操作，并返回头节点
        ListNode pre = null;
        ListNode curr = head;

        while (curr!=null){
            System.out.println(curr.val);
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

}
