package offer;

/**
 * 简单粗暴的记表
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int i:nums){
            count[i]++;
            if (count[i]>1){
                return i;
            }
        }
        return -1;
    }
}
