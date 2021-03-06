import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {

    public static void main(String[] args) {
        Solution931 solution931 = new Solution931();
        solution931.minFallingPathSum(solution931.ar);

    }

    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] mark = new int[max];
        Arrays.fill(mark,max);
        mark[0]=0;

        for (int coin:coins){
            for (int i =coin;i<mark.length;i++){
                mark[i] = Math.min(mark[i],mark[i-coin]+1);
            }
        }

        if (mark[amount]==amount+1){
            return -1;
        }
        return mark[amount];
    }
}