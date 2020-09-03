import java.util.Arrays;

/**
 * 动态规划
 * 画出状态转换方程
 */
public class Solution322 {
    /**
     * 动态规划法
     * 时间击败52
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount==0||coins.length==0){
            return 0;
        }
        if (amount<0){
            return -1;
        }
        int[] res = new int[amount+1];
        //设定最大值
        Arrays.fill(res,amount+1);
        res[0]=0;
        //自底向上走
        for (int i =0;i<res.length;i++){
            //dp(n) = 1+mindp(n-conis)
            for (int coin:coins){
                //排除不符合标准的
                if (i-coin>=0&&res[i-coin]!=amount+1){
                    res[i] = Math.min(res[i],1+res[i-coin]);
                }
            }
        }

        if(res[amount]==amount+1){
            return -1;
        }
        return res[amount];
    }

    /**
     * 完全背包法
     * 时间击败90
     * @param coins
     * @param amount
     * @return
     */
    public int overbag(int[] coins, int amount){
        if (amount==0||coins.length==0){
            return 0;
        }
        if (amount<0){
            return -1;
        }

        //建立记忆集
        int[] res = new int[amount+1];
        Arrays.fill(res,amount+1);
        res[0] = 0;
        //从每个硬币开始算
        for (int coin:coins){
            //计算当前加个需要当前硬币+前面的组合要多少粒
            for (int i = coin;i<=amount;i++){
                //计算最优子解
                res[i] = Math.min(res[i],1+res[i-coin]);
            }
        }
        if(res[amount]==amount+1){
            return -1;
        }
        return res[amount];
    }
}
