/**
 * 类描述
 *
 * @author razor.liu
 * @version 1.0
 * @date 2022/6/23 5:29 PM
 */
public class Solution303 {
    private int[] preNums;

    public Solution303(int[] nums) {
        preNums = new int[nums.length+1];
        for (int i=1;i<preNums.length;i++){
            preNums[i] = preNums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preNums[right+1] - preNums[left];
    }
}
