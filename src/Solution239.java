import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口
 */
public class Solution239 {
    LinkedList<Integer> indexDeque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<=1){
            return nums;
        }

        int res = nums.length-k+1;
        int[] result = new int[res];
        int count = 0;
       for (int i = 0;i<nums.length;i++){
           //确保滑动窗口大小
           if (!indexDeque.isEmpty()&&i-indexDeque.peekFirst()>k-1){
                indexDeque.pollFirst();
           }

           while (!indexDeque.isEmpty()&&nums[indexDeque.peekLast()]<=nums[i]){
               indexDeque.pollLast();
           }

           indexDeque.addLast(i);

           if (i>=k-1){
               result[count] = nums[indexDeque.peekFirst()];
               count++;
           }
       }

       return result;
    }
}
