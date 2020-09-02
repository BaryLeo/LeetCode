/**
 * 描述应该改改：每个阶梯都有一定数量坨屎，一次只能跨一个或者两个阶梯，走到一个阶梯就要吃光上面的屎，
 * 问怎么走才能吃最少的屎？开局你选前两个阶梯的其中一个作为开头点，并吃光该阶梯的屎。
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length<2){
            //少于两级，直接0
            return 0;
        }
        int[] dp = new int[cost.length+1];
        //可以跳一级或者二级
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2;i<dp.length;i++){
            //开始动规
            dp[i] = Math.min(dp[i-1], dp[i-2]) + (i == dp.length-1 ? 0 : cost[i]);
        }

        return dp[dp.length-1];
    }
}
