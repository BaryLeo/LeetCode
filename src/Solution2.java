public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultPoint = result;
        ListNode l1Point = l1;
        ListNode l2Point = l2;

        while (l1Point!=null&&l2Point!=null){
            int sum = resultPoint.val+l1Point.val+l2Point.val;
            if (sum>9){
                resultPoint.val = sum-10;
                resultPoint.next = new ListNode(1);
            }else{
                resultPoint.val = sum;
            }

            if ((l1Point.next!=null||l2Point.next!=null)&&resultPoint.next==null){
                resultPoint.next = new ListNode(0);
            }

            l1Point = l1Point.next;
            l2Point = l2Point.next;
            resultPoint = resultPoint.next;
        }

        if (l1Point !=null){
            singLink(l1Point,resultPoint);
        }

        if (l2Point!=null){
            singLink(l2Point,resultPoint);
        }

        return result;
    }

    public void singLink(ListNode head,ListNode result){
        while (head!=null){
            int sum = head.val+result.val;
            if (sum>9){
               result.val = sum-10;
               result.next = new ListNode(1);
            }else{
                result.val = sum;
            }

            if (head.next!=null&&result.next==null){
                result.next = new ListNode(0);
            }

            head = head.next;
            result = result.next;
        }
    }
}
