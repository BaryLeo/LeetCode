import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

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