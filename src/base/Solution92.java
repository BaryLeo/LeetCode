package base;

public class Solution92 {
    //反正m到n个
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        //题意是1基
        int index = 1;

        ListNode pre = listNode;
        ListNode cur = head;
        while (index<m){
            pre =cur;
            cur = cur.next;
            index++;
        }

        head = pre.next;

        for(int i = m; i < n; i++){
            //记住下面节点
            ListNode nex = head.next;
            //开始反转
            head.next = nex.next;
            //指向子链表的头
            nex.next = pre.next;
            pre.next = nex;
        }
        return listNode.next;
    }
}
