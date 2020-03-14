import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    LinkedList<Integer> indexDeque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1 || nums.length == 0 || k > nums.length) {
            return new int[]{};
        }

        int[] result  = new int[nums.length-k+1];

        int count = 0;
        for (int i = 0;i<nums.length;i++){
            //确保是在窗口范围内
            if (!indexDeque.isEmpty()&&i-indexDeque.peekFirst()>k-1){
                //检查是否超过窗口限度，如果超过了，就弹出
                indexDeque.removeFirst();
            }

            while (!indexDeque.isEmpty()&&nums[i]>=nums[indexDeque.getLast()]){
                //判断本次数据是否比前面的大
                indexDeque.removeLast();
            }

            //然后这次的下标入队
            indexDeque.addLast(i);



            //只有当检查了窗口所有值才会开始赋值
            if (i>=k-1){
                result[count] = nums[indexDeque.getFirst()];
                count++;
            }
        }

        return result;
    }
}
