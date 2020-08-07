package offer;

public class Offer06 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(3);
        Offer06 solution06 = new Offer06();
        for (int i :solution06.reversePrint(listNode)){
            System.out.println(i);
        }
    }

    int[] result;
    int count =0;

    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[]{};
        }
        if (head.next==null){
            return new int[]{head.val};
        }
        build(head,-1);
        return result;
    }

    public void build(ListNode node,int upper){
        if (node==null){
            //0基，得加1
            result = new int[upper+1];
            return;
        }
        int index = upper+1;
        build(node.next,index);
        result[count] = node.val;
        count++;
    }
}