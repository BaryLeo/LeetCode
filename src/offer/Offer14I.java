package leetcode;

public class Offer14I {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        //获取一个阶段
        for (int i = 2;i<=n;i++){
            //计算这个阶段的最优
            for (int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j,dp[j])*(i-j));
            }
        }

        return dp[n];
    }
}
