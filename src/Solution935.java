package leetcode;

public class Solution935 {
    /**
     * 状态方程为dp[n]
     * @param n
     * @return
     */
    public int knightDialer(int n) {
        if (n<1){
            return 0;
        }
        int[][] path = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
        int mod = 1000000007;

        return 0;
    }
}
