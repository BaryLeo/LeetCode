package array_linklist;

/**
 * 快慢指针
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null||head.next.next==null){
            return false;
        }
        ListNode late = head;
        ListNode fast = head.next.next;

        while (late!=fast){
            late = late.next;

            if (fast.next==null||fast.next.next==null){
                return false;
            }
            fast = fast.next.next;
        }

        return true;
    }
}
