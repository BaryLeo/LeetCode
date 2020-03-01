package array.esay;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
       return doublePoint(nums,val);
    }

    //有点像动归
    public int DP(int[] nums, int val){
        int notVBalCount = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[notVBalCount] = nums[i];
                notVBalCount++;
            }
        }
        return notVBalCount;
    }


    public int doublePoint(int[] nums, int val){
        int head = 0;
        int secondHead = 0;
        int loop = 1;
        while (true){
            if (nums[head]==val&&head<nums.length){
                secondHead = head+loop;
                if (secondHead>=nums.length){
                    return head;
                }else if (nums[secondHead]!=val){
                    nums[head] = nums[secondHead];
                    nums[secondHead] = val;
                    loop=1;
                    head++;
                }
            }else {
                head++;
            }
        }
    }


}