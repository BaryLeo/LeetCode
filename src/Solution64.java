public class Solution64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int y = grid.length;
        int x = grid[y - 1].length;

        int dp[][] = new int[y][x];

        dp[0][0] = grid[0][0];

        for (int i = 1;i<x;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1;i<y;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for (int i = 1;i<x;i++){
            for (int m = 1;m<y;m++){
                dp[m][i] = Math.min(dp[m-1][i],dp[m][i-1])+grid[m][i];
            }
        }

        return dp[y-1][x-1];
    }


}
