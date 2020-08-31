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
        if (amount==0){
            return 0;
        }

        if (coins.length==0){
            return -1;
        }

        int[] mark = new int[amount+1];
        Arrays.fill(mark,amount+1);
        mark[0] = 0;
        for (int coin:coins){
            for (int i =coin;i<mark.length;i++){
                mark[i] = Math.min(mark[i],1+mark[i-coin]);
            }
        }

        if (mark[amount]==amount+1){
            return -1;
        }else {
            return mark[amount];
        }
    }
}