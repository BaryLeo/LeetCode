public class Solution931 {

    int[][] ar = new int[][]{{1,2,3},{4,5,6},{7,8,9}};


    public int minFallingPathSum(int[][] A) {
        if (A.length==0){
            return 0;
        }

        int x = A[0].length;
        int y = A.length;

        int[][] dp = new int[y][x];

        for (int i = 0;i<x;i++){
            dp[0][i] = A[0][i];
        }


        for (int i = 1;i<y;i++){
            for (int j = 0;j<x;j++){
                //左上，中间，右上
                if (j>0&&j<x-1){
                    //先比较左上和右上
                    dp[i][j] = Math.min(dp[i-1][j+1],dp[i-1][j-1]);
                    //最后比较然后加上当前的元素
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j])+A[i][j];
                }else if (j==0){
                    //最左边的元素
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+A[i][j];
                }else if (j==x-1){
                    //最右边的元素
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+A[i][j];
                }
            }


        }

        int res = dp[dp.length-1][0];
        for (int i :dp[dp.length-1]){
            res = Math.min(res,i);
        }

        return res;
    }
}
