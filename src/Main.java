import s25_s24.ListNode;
import s25_s24.Solution25_24;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Solution300 solution239 = new Solution300();
        System.out.println(solution239.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

//        Solution994 solution994 = new Solution994();
//        int[][] m = {{2,1,1},{1,1,0},{0,1,1}};
//        System.out.println(solution994.orangesRotting(m));
    }

    public static void printArray(int[] ar){
        for (int i:ar){
            System.out.println(i);
        }
    }
}
