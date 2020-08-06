package array_linklist;

import queue.Solution239;

public class Main {
    public static void main(String[] args) {
        int k =3;
        int[] arr = {1,3,-1,-3,5,3,6,7};
        Solution239 solution239 = new Solution239();
        for (int i:solution239.maxSlidingWindow(arr,3)){
            System.out.println(i);
        }
    }

    public static ListNode detectCycle(ListNode head) {
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
    //206重新做，未完成
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current!=null){
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}
