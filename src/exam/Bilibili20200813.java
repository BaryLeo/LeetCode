package exam;

import java.util.Arrays;
import java.util.LinkedList;

public class Bilibili20200813 {
    /**
     *  给出4个数字，通过加减乘除得到24则返回true
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean Game24Points (int[] arr) {
        // write code here
        for (int i = 0;i<4;i++){
            if (check(arr,i)){
                return true;
            }
        }

        return false;
    }

    private boolean check(int[] ar,int mainIndex){
        int[] nums = new int[3];
        for (int i = 0,count=0;i<4;i++){
            if (i!=mainIndex){
                nums[count] = ar[i];
                count++;
            }
        }
        return false;
    }

    /**
     * AC了
     */
    public boolean IsValidExp (String s) {
        // write code here
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        for (char c:chars){
            if (queue.isEmpty()){
                queue.addLast(c);
            }else {
                int test = Math.abs(queue.peekLast()-c);
                if (test==1||test==2){
                    queue.pollLast();
                }else {
                    queue.addLast(c);
                }
            }
        }
        return queue.isEmpty();
    }

    public int GetCoinCount (int N) {
        // write code here
        int[] coins = new int[]{1,4,16,64};
        int match = 1024-N;
        return find(match,coins);
    }

    private int find(int x,int[] coins){
        System.out.println(x);
        if (x==1){
            return 1;
        }else if (x==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coin:coins){
            if (x>=coin){
                res = Math.min(res,1+find(x-coin,coins));
            }
        }
        return res;
    }
}
