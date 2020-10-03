package leetcode;

public class Offer53 {
    public int missingNumber(int[] nums) {
        int res = nums[nums.length-1];
        for (int i = 0;i<nums[nums.length-1];i++){
            if (nums[i]!=i){
                return i;
            }
        }

        res++;

        return res;
    }
}
