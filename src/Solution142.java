/**
 * 一个定理，快慢指针找到相遇的点'
 *
 * 一个指针指向头，一个指针指向相遇的点，然后每循环一次，都前进一步，然后必定相遇，相遇的点，就是入点
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode late = head;
        ListNode fast = head;
        ListNode mark = null;

        while (fast!=null&&fast.next!=null){
            late = late.next;
            fast = fast.next.next;
            if (late==fast){
                mark = late;
                break;
            }
        }

        if (mark==null){
            return null;
        }

        ListNode result = head;
        while (result!=mark){
            result = result.next;
            mark = mark.next;
        }

        return result;
    }
}
