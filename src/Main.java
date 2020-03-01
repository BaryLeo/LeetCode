import s25_s24.ListNode;
import s25_s24.Solution25_24;

public class Main {

    public static void main(String[] args) {
        Solution25_24 solution25 = new Solution25_24();

        ListNode listNode = new ListNode(0);
        ListNode next =listNode;
        for (int i = 1;i<6;i++){
            ListNode temp = new ListNode(i);
            next.next = temp;
            next = next.next;
        }



        ListNode head = solution25.reverseKGroup(listNode,3);
        while (head!=null){
            System.out.println("用例结果:"+head.val);
            head = head.next;
        }
    }
}
