/**
 *  链表反转I，基础知识
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr!=null){
            //备份当前节点的下一节点指针
            ListNode next = curr.next;

            //然后把当前节点的next指向pre头开头节点
            curr.next  = pre;

            //然后pre移动到当前节点
            pre = curr;

            //curr指向下一节点
            curr = next;
        }

        //因为我循环的条件是curr!=null，所以，pre就是反转后的头结点
        return pre;
    }
}
