package offer;

public class Offer42 {
    /**
     * 确认状态为，以第i结尾的数组
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i =1;i<nums.length;i++){
            //如果是变小了的，就要重新算了
            dp[i] = Math.max(nums[i]+dp[i-1],0);
            max = Math.max(dp[i],max);
        }

        return dp[nums.length-1];
    }
}
