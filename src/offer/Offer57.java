package leetcode;

public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        int[] res = new int[2];
        while (i<j){
            if (nums[i]+nums[j]<target){
                i++;
            }else if (nums[i]+nums[j]>target){
                j--;
            }else {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
        }
        return res;
    }
}
