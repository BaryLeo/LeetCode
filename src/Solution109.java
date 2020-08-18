public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head ==null){
            return null;
        }else if (head.next==null){
            return new TreeNode(head.val);
        }

        //防止nullpointer
        ListNode preCur = head;
        //画图理解，很简单
        ListNode cur = head.next;
        ListNode rear = cur.next;


        while (rear!=null&&rear.next!=null){
            preCur = cur;
            cur = cur.next;
            rear = rear.next.next;
        }

        preCur.next = null;

        TreeNode root = new TreeNode(cur.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(cur.next);

        return root;
    }
}
