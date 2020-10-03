package leetcode;

public class Offer14II {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        for (int i = 0;i<=n;i++){
            for (int j = 0;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(dp[j],j)*(i-j)%1000000007);
            }
        }

        return dp[n];
    }
}
