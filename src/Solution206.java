/**
 * 对第一个温度 23 度，堆栈为空，把它的下标压入堆栈；
 *
 * 下一个温度 24 度，高于 23 度高，因此 23 度温度升高只需 1 天时间，把 23 度下标从堆栈里弹出，把 24 度下标压入；
 *
 * 同样，从 24 度只需要 1 天时间升高到 25 度；
 *
 * 21 度低于 25 度，直接把 21 度下标压入堆栈；
 *
 * 19 度低于 21 度，压入堆栈；
 *
 * 22 度高于 19 度，从 19 度升温只需 1 天，从 21 度升温需要 2 天；
 *
 * 由于堆栈里保存的是下标，能很快计算天数；
 *
 * 22 度低于 25 度，意味着尚未找到 25 度之后的升温，直接把 22 度下标压入堆栈顶端；
 *
 * 后面的温度与此同理。
 *
 * 该方法只需要对数组进行一次遍历，每个元素最多被压入和弹出堆栈一次，算法复杂度是 O(n)。
 *
 * 作者：leo-37
 * 链接：https://leetcode-cn.com/problems/daily-temperatures/solution/yong-zhan-de-fang-fa-jie-jue-by-leo-37/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr!=null){
            //备份当前节点的下一节点指针
            ListNode next = curr.next;

            //然后把当前节点的next指向pre头开头节点
            curr.next  = pre;

            //然后pre移动到当前节点
            pre = curr;

            //curr指向下一节点
            curr = next;
        }

        //因为我循环的条件是curr!=null，所以，pre就是反转后的头结点
        return pre;
    }
}
