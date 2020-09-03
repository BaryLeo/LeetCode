package offer;

public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ba = headA;
        ListNode bb = headB;

        int aLen = 0;
        int bLen = 0;
        while (ba!=null){
            aLen++;
            ba = ba.next;
        }

        while (bb!=null){
            bLen++;
            bb = bb.next;
        }

        int temp = Math.abs(aLen-bLen);
        ba = headA;
        bb = headB;

        if (aLen>bLen){
            int count =0;
            while (count<temp){
                ba = ba.next;
                count++;
            }
        }else {
            int count =0;
            while (count<temp){
                bb = bb.next;
                count++;
            }
        }

        while (ba!=bb){
            ba = ba.next;
            bb = bb.next;
        }

        return ba;
    }
}
