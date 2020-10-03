package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Offer57II {
    public static void main(String[] args) {
        findContinuousSequence(9);
    }
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int i = 1;i<target;i++){
            int curSum = 0;
            int curIndex = 0;
            int point = i;
            while (curSum<target){
                curSum+=point;
                curIndex = point;
                point++;
            }
            if (curSum==target){
                int[] temp = new int[curIndex-i+1];
                for (int x = i,j=0;x<=curIndex;x++,j++){
                    temp[j] = x;
                }
                res.add(temp);
            }
        }

        int[][] find = new int[res.size()][];
        for (int i = 0;i<find.length;i++){
            find[i] = res.get(i);
        }
        return find;
    }
}
