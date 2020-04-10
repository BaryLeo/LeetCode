public class Main {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2= new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = new Solution2().addTwoNumbers(listNode1,listNode2);
        printLits(listNode);
    }

    public static void printArray(int[] ar){
        for (int i:ar){
            System.out.print(i+" ");
        }
    }

    public static void printLits(ListNode listNode){
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
