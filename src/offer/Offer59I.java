package leetcode;

import java.util.LinkedList;

public class Offer59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==0){
            return new int[0];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0;i<nums.length;i++){
            if (queue.isEmpty()){
                queue.addLast(nums[i]);
            }else {
                while (queue.size()>k){
                    queue.pollFirst();
                }
                while ((!queue.isEmpty())&&queue.getLast()<nums[i]){
                    queue.pollLast();
                }
                queue.addLast(nums[i]);
            }

            if (i>=k-1){
                res[i-(k-1)] = queue.getFirst();
            }
        }
        return res;
    }
}
