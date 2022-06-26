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
        if (amount==0){
            return 0;
        }
        if (amount<0){
            return -1;
        }

        int[] dp = new int[amount+1];
        //必须从1开始，不然dp[0]会赋值为Integer.MAX_VALUE
        for (int price = 1;price <= amount;price++){
            int min = Integer.MAX_VALUE;
            for (int coin:coins){
                //price - coin >= 0，确保硬币金额小于当前金额
                //price - dp[price-coin]>=0 确保路线可走
                //dp[price - coin]<min 直接选择最小路线
                if (price - coin >= 0 && price - dp[price-coin]>=0 && dp[price - coin]<min){
                    //要在这里+1,不然会溢出
                    min = dp[price-coin]+1;
                }
            }
            dp[price] = min;
        }

        return Integer.MAX_VALUE == dp[amount]?-1:dp[amount];
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
