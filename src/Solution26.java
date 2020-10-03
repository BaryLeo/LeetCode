import java.util.ArrayList;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }

        ArrayList<Integer> integers = new ArrayList<>();
        int len = 1;
        integers.add(nums[0]);
        for (int i =0;i<nums.length-1;i++){
            if (nums[i]!=nums[i+1]){
                integers.add(nums[i+1]);
                len++;
            }
        }

        for (int i=0;i<integers.size();i++){
            nums[i] = integers.get(i);
        }

        return len;
    }
}
