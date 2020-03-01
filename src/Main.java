import array.esay.Solution27;
import s25.ListNode;
import s25.Solution25;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();

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
