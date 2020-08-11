package base;

/**
 * 反转子链表
 */
public class Solution92 {
    //反正m到n个
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode pre = listNode;
        for(int i=0;i<m;i++){
            pre =pre.next;
        }

        head = pre.next;

        for(int i = m; i < n; i++){
            //记住下面节点
            ListNode nex = head.next;
            //开始反转
            head.next = nex.next;
            //获取上一次的头
            nex.next = pre.next;
            //设置新的头
            pre.next = nex;
        }
        return listNode.next;
    }
}
