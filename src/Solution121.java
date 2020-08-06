public class Solution121 {
    public int maxProfit(int[] prices) {
        return grady(prices);
    }

    /**
     * 这里既是dp，也是贪心算法
     * @param prices
     * @return
     */
    public int grady(int[] prices){
        //持有一个最小的
        int holdMin = Integer.MAX_VALUE;
        //利润
        int profitMax = 0;
        //开始遍历每天的股价，不能前面-后面的，注意这个特性，所以才适合用贪心算法
        //局限性很大
        for (int i:prices){
            //持有一个最小的
            holdMin  = Math.min(holdMin,i);
            profitMax = Math.max(profitMax,i-holdMin);
        }

        return profitMax;
    }
}
